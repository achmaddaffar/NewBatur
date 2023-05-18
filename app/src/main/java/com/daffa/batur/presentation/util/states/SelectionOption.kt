package com.daffa.batur.presentation.util.states

import androidx.annotation.DrawableRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class SelectionOption(
    val option: String,
    initialSelectedValue: Boolean = false,
    @DrawableRes
    val leadingIcon: Int? = null
) {
    var selected by mutableStateOf(initialSelectedValue)
}