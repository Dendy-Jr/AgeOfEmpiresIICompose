package com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.technologies

import com.google.gson.annotations.SerializedName

data class Technologies(
    @SerializedName("technologies")
    val technologies: List<TechnologyItem>
)