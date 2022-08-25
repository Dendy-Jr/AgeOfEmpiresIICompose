package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.screens

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.olehvynnytskyi.android.ageofempiresIIcompose.R
import com.olehvynnytskyi.android.ageofempiresIIcompose.core.extension.changeUrl
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.units.UnitItem
import com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels.UnitDetailsViewModel

@Composable
fun UnitDetailsScreen(
    modifier: Modifier = Modifier,
    id: Int,
    viewModel: UnitDetailsViewModel = hiltViewModel()
) {
    val item = produceState<UnitItem?>(initialValue = null) {
        value = viewModel.getUnitDetails(id)
    }.value ?: return

    Card(
        modifier = modifier.padding(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
        ) {
            DetailsScreenItem(prefix = R.string.name, item = item.name)
            DetailsScreenItem(prefix = R.string.description, item = item.description)
            DetailsScreenItem(prefix = R.string.expansion, item = item.expansion)
            DetailsScreenItem(prefix = R.string.age, item = item.age)
            DetailsScreenItem(prefix = R.string.created_in, item = item.createdIn.changeUrl())

            Text(
                text = stringResource(R.string.cost),
                fontSize = 12.sp,
            )
            item.cost.food?.let { UnitItem(resId = R.string.food, item = it) }
            item.cost.gold?.let { UnitItem(resId = R.string.gold, item = it) }
            item.cost.gold?.let { UnitItem(resId = R.string.gold, item = it) }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(1.dp)
            )

            item.buildTime?.let {
                DetailsScreenItem(
                    prefix = R.string.build_time,
                    item = "$it"
                )
            }
            item.reloadTime?.let {
                DetailsScreenItem(
                    prefix = R.string.reload_time,
                    item = "$it"
                )
            }
            item.attackDelay?.let {
                DetailsScreenItem(
                    prefix = R.string.attack_delay,
                    item = "$it"
                )
            }
            DetailsScreenItem(prefix = R.string.line_of_sight, item = "${item.lineOfSight}")
            DetailsScreenItem(prefix = R.string.hit_points, item = "${item.hitPoints}")
            item.range?.let { DetailsScreenItem(prefix = R.string.range, item = it) }
            item.attack?.let { DetailsScreenItem(prefix = R.string.attack, item = "$it") }
            DetailsScreenItem(prefix = R.string.armor, item = item.armor)
            item.attackBonus?.let {
                DetailsScreenItems(prefix = R.string.attack_bonus, items = it, needDivider = false)
            }
        }
    }
}

@Composable
fun UnitItem(@StringRes resId: Int, item: Any) {
    val annotatedString = buildAnnotatedString {
        withStyle(SpanStyle(fontSize = 12.sp)) {
            append(stringResource(id = resId) + ": ")
        }
        withStyle(SpanStyle(fontWeight = FontWeight.Medium)) {
            append(item.toString())
        }
    }
    Text(text = annotatedString)
}