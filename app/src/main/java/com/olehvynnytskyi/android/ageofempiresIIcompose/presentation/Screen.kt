package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation

sealed class Screen(val route: String) {
    object Home: Screen("home")
    object Civilizations: Screen("civilizations")
    object Units: Screen("units")
    object Structures: Screen("structures")
    object Technologies: Screen("technologies")
}