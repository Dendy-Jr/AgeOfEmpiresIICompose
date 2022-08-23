package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.CivilizationsRepository
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.civilizations.CivilizationItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CivilizationDetailsViewModel @Inject constructor(
    private val repository: CivilizationsRepository
) : ViewModel() {

    suspend fun getCivilizationDetails(id: Int): CivilizationItem {
        return repository.getCivilizationDetails(id)
    }
}