package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.olehvynnytskyi.android.ageofempiresIIcompose.core.extension.changeUrl

@Composable
fun DetailsScreenItem(
    @StringRes prefix: Int,
    item: String,
    style: TextStyle = TextStyle()
) {
    Text(text = stringResource(id = prefix), fontSize = 12.sp)
    Text(
        text = item,
        fontWeight = FontWeight.Medium,
        style = style
    )
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .width(1.dp)
    )
}

@Composable
fun DetailsScreenItems(
    @StringRes prefix: Int,
    items: List<String>,
    needDivider: Boolean = true
) {
    if (items.isEmpty()) return
    Text(
        text = stringResource(prefix),
        fontSize = 12.sp,
    )
    for (item in items) {
        Column {
            DetailsScreenItemUrl(item)
        }
    }
    if (needDivider) {
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .width(1.dp)
        )
    }
}

@Composable
private fun DetailsScreenItemUrl(text: String, style: TextStyle = TextStyle()) {
    Text(
        text = text.changeUrl(),
        fontWeight = FontWeight.Medium,
        style = style
    )
}