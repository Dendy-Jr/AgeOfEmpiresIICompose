package com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.units


import com.google.gson.annotations.SerializedName

data class Units(
    @SerializedName("units")
    val units: List<UnitItem>
)