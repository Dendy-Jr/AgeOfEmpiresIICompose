package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.olehvynnytskyi.android.ageofempiresIIcompose.R
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.structures.StructureItem
import com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels.StructureDetailsViewModel

@Composable
fun StructureDetailsScreen(
    id: Int,
    modifier: Modifier = Modifier,
    viewModel: StructureDetailsViewModel = hiltViewModel()
) {
    val item = produceState<StructureItem?>(initialValue = null) {
        value = viewModel.getStructureDetails(id)
    }.value ?: return

    Card(
        modifier = modifier.padding(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            DetailsScreenItem(prefix = R.string.name, item = item.name)
            DetailsScreenItem(prefix = R.string.expansion, item = item.expansion)
            DetailsScreenItem(prefix = R.string.age, item = item.age)

            Text(
                text = stringResource(R.string.cost),
                fontSize = 12.sp,
            )
            item.cost.gold?.let { UnitItem(resId = R.string.gold_lowercase, item = it) }
            item.cost.stone?.let { UnitItem(resId = R.string.stone, item = it) }
            item.cost.wood?.let { UnitItem(resId = R.string.wood, item = it) }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(1.dp)
            )
            DetailsScreenItem(prefix = R.string.build_time, item = "${item.buildTime}")
            DetailsScreenItem(prefix = R.string.hit_points, item = "${item.hitPoints}")
            DetailsScreenItem(prefix = R.string.line_of_sight, item = "${item.lineOfSight}")
            DetailsScreenItem(
                prefix = R.string.armor,
                item = item.armor,
                needDivider = item.special.isNullOrEmpty().not()
            )

            item.special?.let {
                DetailsScreenItems(prefix = R.string.special, items = it, needDivider = false)
            }
        }
    }
}