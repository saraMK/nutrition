package com.latiff.nutrition.models

import java.io.Serializable

data class NutritionDetails(val calories:Double?=0.0,
                            val totalWeight:Double?=0.0,
                            val totalNutrients:TotalNutrients?=null,
                            val totalDaily:TotalNutrients?=null,
                            val ingredients:List<Ingredients>?=null,

): Serializable

