package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.UnitsRepository
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.units.UnitItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UnitDetailsViewModel @Inject constructor(
    private val repository: UnitsRepository
) : ViewModel() {

    suspend fun getUnitDetails(id: Int): UnitItem {
        return repository.getUnitDetails(id)
    }
}