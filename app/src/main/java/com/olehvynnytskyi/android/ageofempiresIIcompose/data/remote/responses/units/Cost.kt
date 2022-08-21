package com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.units


import com.google.gson.annotations.SerializedName

data class Cost(
    @SerializedName("Cost")
    val cost: String?,
    @SerializedName("Food")
    val food: Int?,
    @SerializedName("Gold")
    val gold: Int?,
    @SerializedName("info")
    val info: String?,
    @SerializedName("Provides")
    val provides: Provides?,
    @SerializedName("Wood")
    val wood: Int?
)