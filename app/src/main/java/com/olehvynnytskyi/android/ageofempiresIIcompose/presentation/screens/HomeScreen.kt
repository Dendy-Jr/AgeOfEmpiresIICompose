package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.olehvynnytskyi.android.ageofempiresIIcompose.R
import com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.Screen
import com.olehvynnytskyi.android.ageofempiresIIcompose.ui.theme.FontPoppins

@Composable
fun HomeScreen(
    navController: NavHostController
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(36.dp))
            Image(
                imageVector = ImageVector.vectorResource(R.drawable.ic_age_of_empires_2_logo),
                contentDescription = null,
                modifier = Modifier.size(width = 240.dp, height = 164.dp)
            )

            Spacer(modifier = Modifier.height(48.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CardSection(sectionName = R.string.civilization) {
                    navController.navigate(Screen.Civilizations.route)
                }
                CardSection(sectionName = R.string.units) {
                    navController.navigate(Screen.Units.route)
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CardSection(sectionName = R.string.structures) {
                    navController.navigate(Screen.Structures.route)
                }
                CardSection(sectionName = R.string.technologies) {
                    navController.navigate(Screen.Technologies.route)
                }
            }
        }
    }
}

@Composable
fun CardSection(
    @StringRes sectionName: Int,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier.size(150.dp),
        elevation = 10.dp
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.clickable { onClick() }
        ) {
            Text(
                text = stringResource(sectionName),
                fontFamily = FontPoppins,
                fontWeight = FontWeight.Medium
            )
        }
    }
}