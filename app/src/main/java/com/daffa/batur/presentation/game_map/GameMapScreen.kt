package com.daffa.batur.presentation.game_map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.wear.compose.material.Text
import com.daffa.batur.data.models.User
import com.daffa.batur.presentation.game_map.components.GameMap
import com.daffa.batur.presentation.game_map.components.MapTopBanner
import com.daffa.batur.presentation.ui.theme.Primary600
import com.daffa.batur.presentation.ui.theme.Primary700
import com.daffa.batur.presentation.ui.theme.Slate25
import com.daffa.batur.presentation.ui.theme.SpaceExtraSmall
import com.daffa.batur.presentation.ui.theme.SpaceSmall

@Composable
fun GameMapScreen(
    navController: NavController,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Slate25)
    ) {
        GameMap(
            modifier = Modifier.fillMaxWidth()
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
        ) {
            MapTopBanner(
                user = User(
                    level = 22,
                    currentXp = 10,
                    maxXp = 125,
                    coin = 70
                )
            )
        }
    }
}