package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.TechnologiesRepository
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.technologies.TechnologyItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TechnologiesViewModel @Inject constructor(
    private val repository: TechnologiesRepository
) : ViewModel() {

    val technologies = mutableStateOf<List<TechnologyItem>>(emptyList())

    init {
        getTechnologies()
    }

    private fun getTechnologies() {
        viewModelScope.launch {
            technologies.value = repository.getTechnologies().technologies
        }
    }
}