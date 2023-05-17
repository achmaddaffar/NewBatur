package com.daffa.batur.data.models

import androidx.compose.ui.graphics.painter.Painter

data class Quiz(
    val question: String,
    val options: List<String>,
    val answer: List<String>,
    val image: Painter? = null
)
