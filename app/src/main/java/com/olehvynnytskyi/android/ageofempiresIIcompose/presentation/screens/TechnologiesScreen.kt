package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.screens

import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.technologies.TechnologyItem
import com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.Screen
import com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels.TechnologiesViewModel
import com.olehvynnytskyi.android.ageofempiresIIcompose.ui.theme.FontPoppins

@Composable
fun TechnologiesScreen(
    modifier: Modifier = Modifier,
    viewModel: TechnologiesViewModel = hiltViewModel(),
    navController: NavController
) {
    val technologies by remember {
        mutableStateOf(viewModel.technologies)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LazyColumn(modifier = modifier.fillMaxSize()) {
            items(technologies.value) {
                TechnologyItem(item = it, navController = navController)
            }
        }
    }
}

@Composable
fun TechnologyItem(
    item: TechnologyItem,
    navController: NavController,
) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize()
            .clickable { navController.navigate(Screen.TechnologyDetails.route + "/${item.id}") },
        elevation = 10.dp
    ) {
        Text(
            text = item.name,
            modifier = Modifier.padding(10.dp),
            fontFamily = FontPoppins
        )
    }
}