package com.latiff.nutrition.network.repo


import com.latiff.nutrition.NetworkApis
import com.latiff.nutrition.models.AnalysisModelRequest
import com.latiff.nutrition.models.NutritionDetails
import com.latiff.nutrition.network.ResultWrapper
import com.latiff.nutrition.network.safeApiCall
import javax.inject.Inject


class DataRepoManger @Inject constructor(val apis: NetworkApis) : DataRepo {
    override suspend fun analysisIngredients(model: AnalysisModelRequest): ResultWrapper<NutritionDetails> {
        return safeApiCall { apis.analysisIngredients(model) }
    }

}