package com.latiff.nutrition.models

import java.io.Serializable

data class TotalNutrients(val ENERC_KCAL :NutrientsItem, // calories
                          val FAT :NutrientsItem, //Fat
                          val FASAT :NutrientsItem,
                          val CHOCDF :NutrientsItem,//Carbohydrate
                          val FIBTG :NutrientsItem,//Fiber
                          val PROCNT :NutrientsItem,//Protein
                          val CHOLE :NutrientsItem,//Cholesterol
                          val SUGAR :NutrientsItem,//Cholesterol
                          val NA :NutrientsItem,//Sodium
                          val CA :NutrientsItem,//Calcium
                          val VITD :NutrientsItem, //vitamin D
                          val K :NutrientsItem,//Potassium
                          val FE :NutrientsItem,//Iron

):Serializable

data class NutrientsItem(val label:String,val unit:String,val quantity:Double): Serializable