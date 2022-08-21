package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.units.UnitItem
import com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels.UnitsViewModel
import com.olehvynnytskyi.android.ageofempiresIIcompose.ui.theme.FontPoppins

@Composable
fun UnitsScreen(
    modifier: Modifier = Modifier,
    viewModel: UnitsViewModel = hiltViewModel()
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {

        val units by remember {
            mutableStateOf(viewModel.units)
        }

        LazyColumn(modifier = modifier.fillMaxSize()) {
            items(units.value) {
                UnitItem(item = it)
            }
        }
    }
}

@Composable
fun UnitItem(item: UnitItem) {
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