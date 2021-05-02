package com.latiff.nutrition.network.repo

import com.latiff.nutrition.models.AnalysisModelRequest
import com.latiff.nutrition.models.NutritionDetails
import com.latiff.nutrition.network.ResultWrapper


interface DataRepo {
     suspend fun analysisIngredients(model:AnalysisModelRequest): ResultWrapper<NutritionDetails>

    }