package com.latiff.nutrition

import com.latiff.nutrition.models.AnalysisModelRequest
import com.latiff.nutrition.models.NutritionDetails
import com.latiff.nutrition.utiles.AppConstants
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query


interface NetworkApis {
    @POST("api/nutrition-details")
    suspend fun analysisIngredients(
        @Body model: AnalysisModelRequest,
        @Query("app_id") app_id: String = AppConstants.ANALYSIS_APP_ID,
        @Query("app_key") app_key: String = AppConstants.ANALYSIS_APP_KEY,
    ): NutritionDetails


}