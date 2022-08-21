package com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.structures


import com.google.gson.annotations.SerializedName

data class Cost(
    @SerializedName("Gold")
    val gold: Int?,
    @SerializedName("Stone")
    val stone: Int?,
    @SerializedName("Wood")
    val wood: Int?
)