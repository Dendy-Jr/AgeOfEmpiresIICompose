package com.olehvynnytskyi.android.ageofempiresIIcompose.core.extension

import java.util.*

fun String.changeUrl(): String {
    return this.replaceBeforeLast("/", "").removePrefix("/").replace("_", " ")
        .replaceFirstChar {
            it.uppercase(Locale.getDefault())
        }
}