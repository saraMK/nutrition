package com.latiff.nutrition.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class TotalNutrients(
    @SerializedName("ENERC_KCAL") val calories: NutrientsItem?, // calories
    @SerializedName("FAT") val fat: NutrientsItem?, //Fat
    @SerializedName("CHOCDF") val carbohydrate: NutrientsItem?,//Carbohydrate
    @SerializedName("FIBTG") val fiber: NutrientsItem?,//Fiber
    @SerializedName("PROCNT") val protein: NutrientsItem?,//Protein
    @SerializedName("CHOLE") val cholesterol: NutrientsItem?,//Cholesterol
    @SerializedName("SUGAR") val sugar: NutrientsItem?,//sugar
    @SerializedName("NA") val sodium: NutrientsItem?,//Sodium
    @SerializedName("CA") val calcium: NutrientsItem?,//Calcium
    @SerializedName("VITD") val vitamin_D: NutrientsItem?, //vitamin D
    @SerializedName("K") val potassium: NutrientsItem?,//Potassium
    @SerializedName("FE") val iron: NutrientsItem?,//Iron

) : Parcelable

@Parcelize
data class NutrientsItem(val label: String, val unit: String, val quantity: Double) : Parcelable