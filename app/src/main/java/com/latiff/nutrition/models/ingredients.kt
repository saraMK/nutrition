package com.latiff.nutrition.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class Ingredients(
val parsed:List<ParsedModel>?
): Parcelable

@Parcelize
data class ParsedModel(val quantity:Double,
                       val measure:String,
                       val food:String,
                       val weight:Double,
                       val nutrients:NutrientsModel,
):Parcelable

@Parcelize
data class NutrientsModel(
    @SerializedName("ENERC_KCAL")
    val calories:NutrientsItem?=null,
):Parcelable