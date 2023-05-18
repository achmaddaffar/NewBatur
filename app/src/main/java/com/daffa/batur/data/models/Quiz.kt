package com.daffa.batur.data.models

import com.daffa.batur.presentation.util.states.SelectionOption

data class Quiz(
    val question: String,
    val options: List<SelectionOption>,
    val answer: List<String>,
    val imageUrl: String? = null
)
