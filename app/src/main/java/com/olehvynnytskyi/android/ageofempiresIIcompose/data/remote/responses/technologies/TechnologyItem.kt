package com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.technologies


import com.google.gson.annotations.SerializedName

data class TechnologyItem(
    @SerializedName("age")
    val age: String,
    @SerializedName("applies_to")
    val appliesTo: List<String>?,
    @SerializedName("build_time")
    val buildTime: Int,
    @SerializedName("cost")
    val cost: Cost,
    @SerializedName("description")
    val description: String,
    @SerializedName("develops_in")
    val developsIn: String,
    @SerializedName("expansion")
    val expansion: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)