package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.AgeOfEmpiresIIRepository
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.CivilizationItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CivilizationsViewModel @Inject constructor(
    private val repository: AgeOfEmpiresIIRepository
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