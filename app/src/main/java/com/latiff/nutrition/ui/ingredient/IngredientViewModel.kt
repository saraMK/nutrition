package com.latiff.nutrition.ui.ingredient

import androidx.lifecycle.liveData
import com.latiff.nutrition.models.Ingredients
import com.latiff.nutrition.models.NutritionDetails
import com.latiff.nutrition.ui.base.BaseViewModel
import com.latiff.nutrition.utiles.Utiles
import javax.inject.Inject

class IngredientViewModel @Inject constructor(): BaseViewModel() {

    private var hasError=false
    fun getListOfIngredients(model: NutritionDetails)= liveData<List<Ingredients>> {
        val list = mutableListOf<Ingredients>()
        model.ingredients?.forEach {
            Utiles.log_D("mmmcmcmcmcmmc","$it    \n ${it?.parsed?.isNullOrEmpty()}")
            if (!it?.parsed.isNullOrEmpty())
                list.add(it)
            else hasError=true
        }
        if (hasError)
            errorMsg.value="check your input"
        else
        emit(list)
    }
}