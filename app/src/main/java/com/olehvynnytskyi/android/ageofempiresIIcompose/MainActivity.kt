package com.olehvynnytskyi.android.ageofempiresIIcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
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
                        CivilizationsScreen(navHostController = navController)
                    }
                    composable(
                        route = Screen.CivilizationDetails.route + "/{id}",
                        arguments = listOf(navArgument("id") {
                            type = NavType.IntType
                        })
                    ) {
                        CivilizationDetailsScreen(
                            id = it.arguments?.getInt("id") ?: return@composable
                        )
                    }
                    composable(Screen.Units.route) {
                        UnitsScreen(navHostController = navController)
                    }
                    composable(
                        route = Screen.UnitDetails.route + "/{id}",
                        arguments = listOf(navArgument("id") {
                            type = NavType.IntType
                        })
                    ) {
                        UnitDetailsScreen(
                            id = it.arguments?.getInt("id") ?: return@composable
                        )
                    }
                    composable(Screen.Structures.route) {
                        StructuresScreen(navHostController = navController)
                    }
                    composable(
                        route = Screen.StructureDetails.route + "/{id}",
                        arguments = listOf(navArgument("id") {
                            type = NavType.IntType
                        })
                    ) {
                        StructureDetailsScreen(
                            id = it.arguments?.getInt("id") ?: return@composable
                        )
                    }
                    composable(Screen.Technologies.route) {
                        TechnologiesScreen()
                    }
                }
            }
        }
    }
}