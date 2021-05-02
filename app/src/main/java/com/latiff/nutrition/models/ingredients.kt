package com.latiff.nutrition.models

import java.io.Serializable

data class Ingredients(
val parsed:List<ParsedModel>
):Serializable

data class ParsedModel(val quantity:Double,
                       val measure:String,
                       val food:String,
                       val weight:Double,
                       val nutrients:NutrientsModel,
):Serializable

data class NutrientsModel(val ENERC_KCAL:NutrientsItem,
):Serializable