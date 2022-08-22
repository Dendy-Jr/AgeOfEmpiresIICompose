package com.olehvynnytskyi.android.ageofempiresIIcompose.data

import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.api.AgeOfEmpiresIIApi
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.technologies.Technologies
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TechnologiesRepository @Inject constructor(
    private val api: AgeOfEmpiresIIApi
) {

    suspend fun getTechnologies(): Technologies {
        return api.getTechnologies()
    }
}