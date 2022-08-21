package com.olehvynnytskyi.android.ageofempiresIIcompose.data

import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.api.AgeOfEmpiresIIApi
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.units.Units
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UnitsRepository @Inject constructor(
    private val api: AgeOfEmpiresIIApi
) {
    suspend fun getUnits(): Units {
        return api.getUnits()
    }
}