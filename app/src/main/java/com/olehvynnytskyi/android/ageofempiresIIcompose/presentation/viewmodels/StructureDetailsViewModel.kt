package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels

import androidx.lifecycle.ViewModel
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.StructuresRepository
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.structures.StructureItem
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class StructureDetailsViewModel @Inject constructor(
    private val repository: StructuresRepository,
) : ViewModel() {

    suspend fun getStructureDetails(id: Int): StructureItem {
        return repository.getStructureDetails(id)
    }
}