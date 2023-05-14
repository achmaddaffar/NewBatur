package com.daffa.batur.presentation.util.states

import com.daffa.batur.util.Constants.Empty

data class CustomTextFieldState(
    val text: String = String.Empty,
    val error: String = String.Empty
)
