package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.olehvynnytskyi.android.ageofempiresIIcompose.core.extension.changeUrl
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.technologies.TechnologyItem
import com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels.TechnologyDetailsViewModel

@Composable
fun TechnologyDetailsScreen(
    modifier: Modifier = Modifier,
    id: Int,
    viewModel: TechnologyDetailsViewModel = hiltViewModel()
) {
    val item = produceState<TechnologyItem?>(initialValue = null) {
        value = viewModel.getTechnologyDetails(id)
    }.value ?: return

    Card(
        modifier = modifier.padding(8.dp),
        elevation = 4.dp
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            DetailsScreenItem(prefix = R.string.name, item = item.name)
            DetailsScreenItem(prefix = R.string.description, item = item.description)
            DetailsScreenItem(prefix = R.string.expansion, item = item.expansion)
            DetailsScreenItem(prefix = R.string.age, item = item.age)
            DetailsScreenItem(prefix = R.string.develops_in, item = item.developsIn.changeUrl())

            Text(
                text = stringResource(R.string.cost),
                fontSize = 12.sp,
            )
            item.cost.wood?.let { UnitItem(resId = R.string.wood, item = it) }
            item.cost.food?.let { UnitItem(resId = R.string.food, item = it) }
            item.cost.stone?.let { UnitItem(resId = R.string.stone, item = it) }
            item.cost.gold?.let { UnitItem(resId = R.string.gold_lowercase, item = it) }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .width(1.dp)
            )
            DetailsScreenItem(prefix = R.string.build_time, item = "${item.buildTime}")
            item.appliesTo?.let {
                DetailsScreenItems(
                    prefix = R.string.applies_to,
                    items = it,
                    needDivider = false
                )
            }
        }
    }
}