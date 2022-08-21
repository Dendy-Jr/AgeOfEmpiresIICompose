package com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.structures


import com.google.gson.annotations.SerializedName

data class StructureItem(
    @SerializedName("age")
    val age: String,
    @SerializedName("armor")
    val armor: String,
    @SerializedName("attack")
    val attack: Int?,
    @SerializedName("build_time")
    val buildTime: Int,
    @SerializedName("cost")
    val cost: Cost,
    @SerializedName("expansion")
    val expansion: String,
    @SerializedName("hit_points")
    val hitPoints: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("line_of_sight")
    val lineOfSight: Int?,
    @SerializedName("name")
    val name: String,
    @SerializedName("range")
    val range: String?,
    @SerializedName("reload_time")
    val reloadTime: Double?,
    @SerializedName("special")
    val special: List<String>?
)