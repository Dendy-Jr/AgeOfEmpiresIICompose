package com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.technologies

import com.google.gson.annotations.SerializedName

data class Cost(
    @SerializedName("Enemy Villager")
    val enemyVillager: Int?,
    @SerializedName("Food")
    val food: Int?,
    @SerializedName("Gold")
    val gold: Int?,
    @SerializedName("Stone")
    val stone: Int?,
    @SerializedName("Wood")
    val wood: Int?
)