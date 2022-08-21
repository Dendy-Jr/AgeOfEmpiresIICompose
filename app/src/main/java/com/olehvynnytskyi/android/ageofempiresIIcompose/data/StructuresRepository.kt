package com.olehvynnytskyi.android.ageofempiresIIcompose.data

import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.api.AgeOfEmpiresIIApi
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.structures.Structures
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class StructuresRepository @Inject constructor(
    private val api: AgeOfEmpiresIIApi
) {

    suspend fun getStructures(): Structures {
        return api.getStructures()
    }
}