package com.olehvynnytskyi.android.ageofempiresIIcompose.data

import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.api.AgeOfEmpiresIIApi
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.Civilizations
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AgeOfEmpiresIIRepository @Inject constructor(
    private val api: AgeOfEmpiresIIApi
) {
    suspend fun getCivilizations(): Civilizations {
        return api.getCivilizations()
    }
}