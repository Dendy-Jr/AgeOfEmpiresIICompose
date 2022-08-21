package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.structures.StructureItem
import com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels.StructuresViewModel
import com.olehvynnytskyi.android.ageofempiresIIcompose.ui.theme.FontPoppins

@Composable
fun StructuresScreen(
    modifier: Modifier = Modifier,
    viewModel: StructuresViewModel = hiltViewModel()
) {

    val structures by remember {
        mutableStateOf(viewModel.structures)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),

            ) {
            items(structures.value) {
                StructureItem(it)
            }
        }
    }
}

@Composable
fun StructureItem(item: StructureItem) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize(),
        elevation = 10.dp
    ) {
        Text(
            text = item.name,
            modifier = Modifier.padding(10.dp),
            fontFamily = FontPoppins
        )
    }
}