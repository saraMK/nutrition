package com.latiff.nutrition.ui.ingredient

import androidx.lifecycle.liveData
import com.latiff.nutrition.models.Ingredients
import com.latiff.nutrition.models.NutritionDetails
import com.latiff.nutrition.ui.base.BaseViewModel
import javax.inject.Inject

class IngredientViewModel @Inject constructor(): BaseViewModel() {

    fun getListOfIngredients(model: NutritionDetails)= liveData<List<Ingredients>> {
        model.ingredients?.let { emit(it) }
    }
}