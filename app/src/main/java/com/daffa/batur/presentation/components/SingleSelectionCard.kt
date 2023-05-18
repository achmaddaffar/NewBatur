package com.daffa.batur.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.daffa.batur.presentation.ui.theme.IconSizeMedium
import com.daffa.batur.presentation.ui.theme.Primary600
import com.daffa.batur.presentation.ui.theme.Slate100
import com.daffa.batur.presentation.ui.theme.SpaceMedium
import com.daffa.batur.presentation.util.states.SelectionOption

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SingleSelectionCard(
    modifier: Modifier = Modifier,
    selectionOption: SelectionOption,
    cardColor: Color = Color.White,
    leadingIconSize: Dp = IconSizeMedium,
    onOptionClicked: (SelectionOption) -> Unit,
) {
    Card(
        modifier = modifier,
        shape = MaterialTheme.shapes.medium,
        onClick = { onOptionClicked(selectionOption) },
        elevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(cardColor)
                .padding(SpaceMedium),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                if (selectionOption.leadingIcon != null) {
                    Image(
                        painter = painterResource(id = selectionOption.leadingIcon),
                        contentDescription = selectionOption.option,
                        modifier = Modifier
                            .size(leadingIconSize)
                    )
                    Spacer(modifier = Modifier.width(SpaceMedium))
                }
                Text(
                    text = selectionOption.option,
                    style = MaterialTheme.typography.body1
                )
            }
            RadioButton(
                selected = selectionOption.selected,
                colors = RadioButtonDefaults.colors(
                    selectedColor = Primary600,
                    unselectedColor = Slate100
                ),
                onClick = { onOptionClicked(selectionOption) }
            )
        }
    }
}