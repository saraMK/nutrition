package com.latiff.nutrition.ui.nutrition

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.latiff.nutrition.models.NutritionDetails
import com.latiff.nutrition.models.TotalNutrients
import com.latiff.nutrition.ui.base.BaseViewModel
import com.latiff.nutrition.utiles.Utiles
import javax.inject.Inject

class NutritionViewModel @Inject constructor():BaseViewModel() {
    val nutritionDetails= ObservableField<TotalNutrients> ()

    fun getDelayNutritionDetails(model:NutritionDetails){


        nutritionDetails.set(model.totalNutrients)
    }
}