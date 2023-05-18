package com.daffa.batur.data.models

import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.painter.Painter

data class Quiz(
    val question: String,
    val options: List<String>,
    val answer: List<String>,
    @DrawableRes
    val image: Int? = null
)
