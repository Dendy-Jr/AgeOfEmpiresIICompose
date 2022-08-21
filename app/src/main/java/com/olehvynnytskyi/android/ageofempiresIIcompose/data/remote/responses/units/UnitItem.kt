package com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.units


import com.google.gson.annotations.SerializedName

data class UnitItem(
    @SerializedName("accuracy")
    val accuracy: String?,
    @SerializedName("age")
    val age: String,
    @SerializedName("armor")
    val armor: String,
    @SerializedName("armor_bonus")
    val armorBonus: List<String>?,
    @SerializedName("attack")
    val attack: Int?,
    @SerializedName("attack_bonus")
    val attackBonus: List<String>?,
    @SerializedName("attack_delay")
    val attackDelay: Double?,
    @SerializedName("blast_radius")
    val blastRadius: Double?,
    @SerializedName("build_time")
    val buildTime: Int?,
    @SerializedName("cost")
    val cost: Cost,
    @SerializedName("created_in")
    val createdIn: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("expansion")
    val expansion: String,
    @SerializedName("hit_points")
    val hitPoints: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("line_of_sight")
    val lineOfSight: Int,
    @SerializedName("movement_rate")
    val movementRate: Double?,
    @SerializedName("name")
    val name: String,
    @SerializedName("range")
    val range: String?,
    @SerializedName("reload_time")
    val reloadTime: Double?,
    @SerializedName("search_radius")
    val searchRadius: Int?
)