package com.olehvynnytskyi.android.ageofempiresIIcompose.data

import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.api.AgeOfEmpiresIIApi
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.civilizations.CivilizationItem
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.civilizations.Civilizations
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CivilizationsRepository @Inject constructor(
    private val api: AgeOfEmpiresIIApi
) {
    suspend fun getCivilizations(): Civilizations {
        return api.getCivilizations()
    }

    suspend fun getCivilizationDetails(id: Int): CivilizationItem {
        return api.getCivilizationDetails(id)
    }
}