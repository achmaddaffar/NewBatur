package com.daffa.batur.data.models

import androidx.compose.ui.graphics.painter.Painter

data class BottomNavItem(
    val route: String,
    val icon: Painter? = null,
    val contentDescription: String? = null,
    val alertCount: Int? = null
)
