package com.latiff.nutrition.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class NutritionDetails(val calories:Double?=0.0,
                            val totalWeight:Double?=0.0,
                            val totalNutrients:TotalNutrients?=null,
                            val totalDaily:TotalNutrients?=null,
                            val ingredients:List<Ingredients>?=null,

): Parcelable

