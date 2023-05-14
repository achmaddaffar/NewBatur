package com.daffa.batur.presentation.util.states

import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.painter.Painter

class SelectionOption(
    val option: String,
    initialSelectedValue: Boolean,
    @DrawableRes
    val leadingIcon: Int? = null
) {
    var selected by mutableStateOf(initialSelectedValue)
}