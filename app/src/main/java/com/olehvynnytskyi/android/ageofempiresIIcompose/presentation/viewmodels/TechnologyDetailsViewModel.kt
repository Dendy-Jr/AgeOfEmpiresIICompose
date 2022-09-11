package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.TechnologiesRepository
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.technologies.TechnologyItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TechnologyDetailsViewModel @Inject constructor(
    private val repository: TechnologiesRepository
) : ViewModel() {

    suspend fun getTechnologyDetails(id: Int): TechnologyItem {
        return repository.getTechnologyDetails(id)
    }
}