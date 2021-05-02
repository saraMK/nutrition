package com.latiff.nutrition.ui.nutrition

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.latiff.nutrition.models.NutritionDetails
import com.latiff.nutrition.models.TotalNutrients
import com.latiff.nutrition.ui.base.BaseViewModel
import com.latiff.nutrition.utiles.Utiles
import javax.inject.Inject

class NutritionViewModel @Inject constructor() : BaseViewModel() {
    val nutritionDetails = ObservableField<TotalNutrients>()
    val viewDetails = ObservableField<Boolean>(false)

    fun getDelayNutritionDetails(model: NutritionDetails) {

        if (model.totalNutrients?.calories?.quantity != null) {
            nutritionDetails.set(model.totalNutrients)
            viewDetails.set(true)
        }else errorMsg.value="check your input"
    }
}