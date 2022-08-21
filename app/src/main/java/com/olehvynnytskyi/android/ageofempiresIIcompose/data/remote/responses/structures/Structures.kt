package com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.structures


import com.google.gson.annotations.SerializedName

data class Structures(
    @SerializedName("structures")
    val structures: List<StructureItem>
)