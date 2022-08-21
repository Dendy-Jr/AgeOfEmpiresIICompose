package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.CivilizationsRepository
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.civilizations.CivilizationItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CivilizationsViewModel @Inject constructor(
    private val repository: CivilizationsRepository
) : ViewModel() {

    val civilizations = mutableStateOf<List<CivilizationItem>>(emptyList())

    init {
        getCivilizations()
    }

    private fun getCivilizations() {
        viewModelScope.launch {
            civilizations.value = repository.getCivilizations().civilizations
        }
    }
}