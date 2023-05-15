package com.daffa.batur.data.models

import com.daffa.batur.util.Constants.Empty

data class User(
    val username: String = String.Empty,
    val level: Int = 0,
    val currentXp: Int = 0,
    val maxXp: Int = 0,
    val coin: Int = 0,
    val suku: String = String.Empty
)
