package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.UnitsRepository
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.units.UnitItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UnitsViewModel @Inject constructor(
    private val repository: UnitsRepository
) : ViewModel() {

    val units = mutableStateOf<List<UnitItem>>(emptyList())

    init {
        getUnits()
    }

    private fun getUnits() {
        viewModelScope.launch {
            units.value = repository.getUnits().units.sortedBy {
                it.name
                //TODO Move it to use case
            }
        }
    }
}