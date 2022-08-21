package com.olehvynnytskyi.android.ageofempiresIIcompose.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.olehvynnytskyi.android.ageofempiresIIcompose.R

val FontPoppins = FontFamily(
    Font(resId = R.font.poppins_regular),
    Font(resId = R.font.poppins_medium, weight = FontWeight.Medium)
)

// Set of Material typography styles to start with
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontPoppins,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)