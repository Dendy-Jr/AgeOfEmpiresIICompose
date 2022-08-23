package com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.api

import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.civilizations.CivilizationItem
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.civilizations.Civilizations
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.structures.Structures
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.technologies.Technologies
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.units.Units
import retrofit2.http.GET
import retrofit2.http.Path

interface AgeOfEmpiresIIApi {

    @GET("api/v1/civilizations")
    suspend fun getCivilizations(): Civilizations

    @GET("api/v1/units")
    suspend fun getUnits(): Units

    @GET("api/v1/structures")
    suspend fun getStructures(): Structures

    @GET("api/v1/technologies")
    suspend fun getTechnologies(): Technologies

    @GET("api/v1/civilization/{id}")
    suspend fun getCivilizationDetails(@Path("id") id: Int): CivilizationItem
}