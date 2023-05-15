package com.daffa.batur.presentation.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.wear.compose.material.Text
import com.daffa.batur.data.models.User
import com.daffa.batur.presentation.profile.components.ProfileSectionCard
import com.daffa.batur.presentation.ui.theme.SpaceLarge

@Composable
fun ProfileScreen(
    navController: NavController,
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(SpaceLarge)
    ) {
        item {
            ProfileSectionCard(
                user = User(
                    username = "test",
                    email = "test@mail.com",
                    level = 2,
                    currentXp = 35,
                    maxXp = 150,
                    coin = 25,
                    suku = "Jawa"
                )
            )
        }
    }
}