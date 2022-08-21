package com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.units


import com.google.gson.annotations.SerializedName

data class Provides(
    @SerializedName("Food")
    val food: Int,
    @SerializedName("Resource Decay")
    val resourceDecay: Double
)