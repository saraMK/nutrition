package com.latiff.nutrition.ui.home

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.latiff.nutrition.ui.base.BaseViewModel
import com.latiff.nutrition.network.ResultWrapper
import com.latiff.nutrition.models.AnalysisModelRequest
import com.latiff.nutrition.utiles.Utiles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.latiff.nutrition.R
import com.latiff.nutrition.models.NutritionDetails
import com.latiff.nutrition.network.repo.DataRepo
import kotlinx.coroutines.withContext

public class HomeViewModel @Inject constructor(val repo: DataRepo) : BaseViewModel() {
    val ingredients = ObservableField<String>("")

    private var errorMsgFieldObservable = ObservableField<Int>(0)
    val errorMsgField
        get() = errorMsgFieldObservable

    private val nutritionDetails: MutableLiveData<NutritionDetails> = MutableLiveData()
    val nutritionDetailsLiveData: MutableLiveData<NutritionDetails>
        get() = nutritionDetails

    private var ingredients_list: MutableList<String> = mutableListOf()
    val ingredientsList
        get() = ingredients_list

    fun analysisIngredients() {
        if (getAnalysisList()) {
            loader.set(true)
            val model = AnalysisModelRequest(ingredients_list)
            viewModelScope.launch(Dispatchers.IO) {
                val result = repo.analysisIngredients(model)
                Utiles.log_D("resultss", "$result")
                when (result) {
                    is ResultWrapper.Success -> {

                            withContext(Dispatchers.Main) {
                                nutritionDetails.value = result.value
                                resetLiveData(nutritionDetails)
                            }

                    }
                    else -> getErrorMsg(result)
                }
                loader.set(false)

            }
        }
    }


    fun getAnalysisList(): Boolean {
        var valid = false
        val text = ingredients.get()?.trim()
        if (!text.isNullOrEmpty()) {
            errorMsgFieldObservable.set(0)
            val list = ingredients.get()?.split("\n")
            ingredients_list = mutableListOf()
            list?.forEach {
                if (it.isNotEmpty())
                    ingredients_list.add(it.trim())
            }
            valid = true

        } else errorMsgFieldObservable.set(R.string.required)

        return valid
    }
}