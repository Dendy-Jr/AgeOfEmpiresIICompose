package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.StructuresRepository
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.structures.StructureItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class StructuresViewModel @Inject constructor(
    private val repository: StructuresRepository
): ViewModel() {

    val structures = mutableStateOf<List<StructureItem>>(emptyList())

    init {
        getStructures()
    }

    private fun getStructures() {
        viewModelScope.launch {
            structures.value = repository.getStructures().structures
        }
    }
}