package com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.civilizations

import com.google.gson.annotations.SerializedName

data class CivilizationItem(
    @SerializedName("army_type")
    val armyType: String,
    @SerializedName("civilization_bonus")
    val civilizationBonus: List<String>,
    @SerializedName("expansion")
    val expansion: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("team_bonus")
    val teamBonus: String,
    @SerializedName("unique_tech")
    val uniqueTech: List<String>,
    @SerializedName("unique_unit")
    val uniqueUnit: List<String>
)