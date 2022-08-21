package com.olehvynnytskyi.android.ageofempiresIIcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.Screen
import com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.screens.*
import com.olehvynnytskyi.android.ageofempiresIIcompose.ui.theme.AgeOfEmpiresIIComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AgeOfEmpiresIIComposeTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.Home.route) {
                    composable(Screen.Home.route) {
                        HomeScreen(navController)
                    }
                    composable(Screen.Civilizations.route) {
                        CivilizationsScreen()
                    }
                    composable(Screen.Units.route) {
                        UnitsScreen()
                    }
                    composable(Screen.Structures.route) {
                        StructuresScreen()
                    }
                    composable(Screen.Technologies.route) {
                        TechnologiesScreen()
                    }
                }
            }
        }
    }
}