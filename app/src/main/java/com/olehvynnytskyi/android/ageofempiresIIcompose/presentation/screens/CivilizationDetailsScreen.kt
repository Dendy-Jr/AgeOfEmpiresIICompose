package com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.olehvynnytskyi.android.ageofempiresIIcompose.R
import com.olehvynnytskyi.android.ageofempiresIIcompose.data.remote.responses.civilizations.CivilizationItem
import com.olehvynnytskyi.android.ageofempiresIIcompose.presentation.viewmodels.CivilizationDetailsViewModel

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
            DetailsScreenItem(prefix = R.string.name, item = item.name)
            DetailsScreenItem(prefix = R.string.expansion, item = item.expansion)
            DetailsScreenItem(prefix = R.string.army_type, item = item.armyType)

            DetailsScreenItems(prefix = R.string.unique_unit, items = item.uniqueUnit)
            DetailsScreenItems(prefix = R.string.unique_tech, items = item.uniqueTech)

            DetailsScreenItem(prefix = R.string.team_bonus, item = item.teamBonus)
            DetailsScreenItems(
                prefix = R.string.civilization_bonus,
                items = item.civilizationBonus,
                needDivider = false
            )
        }
    }
}