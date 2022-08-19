package com.olehvynnytskyi.android.ageofempiresIIcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.screens.CivilizationsScreen
import com.olehvynnytskyi.android.ageofempiresIIcompose.ui.theme.MMOGamesComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MMOGamesComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CivilizationsScreen()
                }
            }
        }
    }
}