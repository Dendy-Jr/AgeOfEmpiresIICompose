package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.civilizations.CivilizationItem
import com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.Screen
import com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels.CivilizationsViewModel
import com.olehvynnytskyi.android.ageofempiresIIcompose.ui.theme.FontPoppins

@Composable
fun CivilizationsScreen(
    modifier: Modifier = Modifier,
    viewModel: CivilizationsViewModel = hiltViewModel(),
    navHostController: NavHostController
) {
    val civilizations by remember {
        mutableStateOf(viewModel.civilizations)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LazyColumn(modifier = modifier.fillMaxSize()) {
            items(civilizations.value) {
                CivilizationItem(item = it, navHostController = navHostController)
            }
        }
    }
}

@Composable
fun CivilizationItem(
    item: CivilizationItem,
    navHostController: NavHostController
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize()
            .clickable {
                navHostController.navigate(Screen.CivilizationDetails.route + "/${item.id}")
            },
        elevation = 10.dp
    ) {
        Text(
            text = item.name,
            modifier = Modifier.padding(10.dp),
            fontFamily = FontPoppins
        )
    }
}