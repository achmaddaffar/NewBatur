package com.daffa.batur.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyItemScope
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.daffa.batur.presentation.ui.theme.SpaceMedium
import com.daffa.batur.presentation.ui.theme.SpaceSmall
import com.daffa.batur.presentation.util.states.SelectionOption

@Composable
fun SingleSelectionList(
    modifier: Modifier = Modifier,
    options: List<SelectionOption>,
    onOptionClicked: (SelectionOption) -> Unit,
    contentAfter: @Composable LazyItemScope.() -> Unit = {}
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(options) { option ->
            Spacer(modifier = Modifier.height(SpaceSmall))
            SingleSelectionCard(
                selectionOption = option,
                onOptionClicked = onOptionClicked
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
        }
        item {
            contentAfter()
        }
    }
}