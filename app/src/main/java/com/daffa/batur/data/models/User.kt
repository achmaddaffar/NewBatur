package com.daffa.batur.data.models

import com.daffa.batur.util.Constants.Empty

data class User(
    val token: String = String.Empty,
    val username: String = String.Empty,
)
