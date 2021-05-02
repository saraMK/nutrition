package com.latiff.nutrition.network.repo

import com.latiff.nutrition.models.AnalysisModelRequest
import com.latiff.nutrition.models.NutritionDetails
import com.latiff.nutrition.network.ResultWrapper
import javax.inject.Inject
import javax.inject.Named

class FakeDataRepo @Inject @Named("FakeDataRepo") constructor() :DataRepo {

   private val model_ =NutritionDetails()
    override suspend fun analysisIngredients(model: AnalysisModelRequest): ResultWrapper<NutritionDetails> {

        return ResultWrapper.Success(model_)
    }
}