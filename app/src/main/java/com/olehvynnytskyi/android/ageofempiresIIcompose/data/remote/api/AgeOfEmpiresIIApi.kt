package com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.api

import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.civilizations.Civilizations
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.units.Units
import retrofit2.http.GET

interface AgeOfEmpiresIIApi {

    @GET("api/v1/civilizations")
    suspend fun getCivilizations(): Civilizations

    @GET("api/v1/units")
    suspend fun getUnits(): Units
}