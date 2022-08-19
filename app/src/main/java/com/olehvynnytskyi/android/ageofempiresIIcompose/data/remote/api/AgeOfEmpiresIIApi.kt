package com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.api

import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.Civilizations
import retrofit2.http.GET

interface AgeOfEmpiresIIApi {

    @GET("api/v1/civilizations")
    suspend fun getCivilizations(): Civilizations
}