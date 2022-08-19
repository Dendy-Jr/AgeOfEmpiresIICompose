package com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses

import com.google.gson.annotations.SerializedName

data class Civilizations(
    @SerializedName("civilizations")
    val civilizations: List<CivilizationItem>
)