package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.olehvynnytskyi.android.ageofempiresIIcompose.R
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.civilizations.CivilizationItem
import com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels.CivilizationsViewModel
import java.util.*

@Composable
fun CivilizationsScreen(
    modifier: Modifier = Modifier,
    viewModel: CivilizationsViewModel = hiltViewModel(),
) {
    val mmoList by remember {
        mutableStateOf(viewModel.civilizations)
    }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        LazyColumn(modifier = modifier.fillMaxSize()) {
            items(mmoList.value) {
                CivilizationItem(item = it)
            }
        }
    }
}

@Composable
fun CivilizationItem(item: CivilizationItem) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxSize(),
        elevation = 10.dp
    ) {
        Column(modifier = Modifier.padding(4.dp)) {
            TextSpan(prefix = R.string.name, second = item.name)
            TextSpan(prefix = R.string.expansion, second = item.expansion)
            TextSpan(prefix = R.string.army_type, second = item.armyType)

            UniqueItems(prefix = R.string.unique_unit, items = item.uniqueUnit)
            UniqueItems(prefix = R.string.unique_tech, items = item.uniqueTech)
            TextSpan(prefix = R.string.team_bonus, second = item.teamBonus)
            UniqueItems(prefix = R.string.civilization_bonus, items = item.civilizationBonus)
        }
    }
}

@Composable
fun UniqueItems(
    @StringRes prefix: Int,
    items: List<String>,
    composable: @Composable () -> Unit = {}
) {
    if (items.isNotEmpty()) {
        Row {
            val text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 10.sp)) {
                    append("${stringResource(prefix)}: ")
                }
                Column {
                    items.onEach {
                        val unit =
                            it.replaceBeforeLast("/", "").removePrefix("/").replace("_", "  ")
                                .replaceFirstChar {
                                    it.uppercase(Locale.getDefault())
                                }
                        withStyle(style = SpanStyle(color = Color.Blue, fontSize = 12.sp)) {
                            append(unit)
                            if (items.size > 1) {
                                if (it != items.last()) {
                                    append(", ")
                                }
                            }
                        }
                    }
                }
            }
            Text(
                text = text,
                modifier = Modifier.padding(bottom = 4.dp)
            )
            composable()
        }
    }
}

@Composable
fun TextSpan(@StringRes prefix: Int, second: String) {
    val text = buildAnnotatedString {
        withStyle(style = SpanStyle(fontSize = 10.sp)) {
            append("${stringResource(prefix)}: ")
        }
        withStyle(style = SpanStyle(color = Color.Blue, fontSize = 12.sp)) {
            append(second)
        }
    }
    Text(text = text)
}