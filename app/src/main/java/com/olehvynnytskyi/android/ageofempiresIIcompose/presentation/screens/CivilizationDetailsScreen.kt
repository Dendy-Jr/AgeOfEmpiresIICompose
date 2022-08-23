@file:OptIn(ExperimentalTextApi::class)

package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.olehvynnytskyi.android.ageofempiresIIcompose.R
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.civilizations.CivilizationItem
import com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels.CivilizationDetailsViewModel
import com.olehvynnytskyi.android.ageofempiresIIcompose.ui.theme.Charcoal
import com.olehvynnytskyi.android.ageofempiresIIcompose.ui.theme.DarkBlue
import com.olehvynnytskyi.android.ageofempiresIIcompose.ui.theme.LightBlue
import com.olehvynnytskyi.android.ageofempiresIIcompose.ui.theme.Yellow
import java.util.*

@Composable
fun CivilizationDetailsScreen(
    modifier: Modifier = Modifier,
    id: Int,
    viewModel: CivilizationDetailsViewModel = hiltViewModel()
) {
    val item = produceState<CivilizationItem?>(initialValue = null) {
        value = viewModel.getCivilizationDetails(id)
    }.value ?: return

    Card(
        modifier = modifier.padding(8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            SectionText(prefix = R.string.name, item = item.name)
            SectionText(prefix = R.string.expansion, item = item.expansion)
            SectionText(prefix = R.string.army_type, item = item.armyType)

            SectionUniqueItems(prefix = R.string.unique_unit, items = item.uniqueUnit)
            SectionUniqueItems(prefix = R.string.unique_tech, items = item.uniqueTech)

            SectionText(prefix = R.string.team_bonus, item = item.teamBonus)
            SectionUniqueItems(
                prefix = R.string.civilization_bonus,
                items = item.civilizationBonus,
                needDivider = false
            )
        }
    }
}

@Composable
fun UniqueItem(text: String) {
    val unique = text.replaceBeforeLast("/", "").removePrefix("/").replaceFirstChar {
        it.uppercase(Locale.getDefault())
    }
    Text(
        text = unique,
        fontWeight = FontWeight.Medium,
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = listOf(
                    LightBlue,
                    DarkBlue
                ),
                tileMode = TileMode.Mirror
            )
        )
    )
}

@Composable
fun SectionText(@StringRes prefix: Int, item: String) {
    Text(text = stringResource(id = prefix), fontSize = 12.sp)
    Text(
        text = item,
        fontWeight = FontWeight.Medium,
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = listOf(
                    Charcoal,
                    Yellow
                ),
                tileMode = TileMode.Mirror
            )
        )
    )
    Divider(
        modifier = Modifier
            .fillMaxWidth()
            .width(1.dp)
    )
}

@Composable
fun SectionUniqueItems(@StringRes prefix: Int, items: List<String>, needDivider: Boolean = true) {
    if (items.isEmpty()) return
    Text(
        text = stringResource(prefix),
        fontSize = 12.sp,
    )
    LazyColumn {
        items(items) {
            UniqueItem(it)
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