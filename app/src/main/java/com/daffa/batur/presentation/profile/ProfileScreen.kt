package com.daffa.batur.presentation.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.daffa.batur.R
import com.daffa.batur.data.models.User
import com.daffa.batur.presentation.components.CustomButton
import com.daffa.batur.presentation.profile.components.ProfileSectionCard
import com.daffa.batur.presentation.ui.theme.IconSizeMedium
import com.daffa.batur.presentation.ui.theme.Primary600
import com.daffa.batur.presentation.ui.theme.Secondary600
import com.daffa.batur.presentation.ui.theme.Slate300
import com.daffa.batur.presentation.ui.theme.SpaceExtraSmall
import com.daffa.batur.presentation.ui.theme.SpaceLarge
import com.daffa.batur.presentation.ui.theme.SpaceMedium
import com.daffa.batur.presentation.ui.theme.SpaceSmall
import com.daffa.batur.presentation.ui.theme.SpaceUltraLarge
import com.daffa.batur.presentation.util.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel = koinViewModel(),
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(SpaceLarge)
                .align(Alignment.TopCenter)
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
                Spacer(modifier = Modifier.height(SpaceMedium))
            }
            item {
                Text(
                    text = stringResource(R.string.absen_harian),
                    style = MaterialTheme.typography.body1
                )
                Card(
                    border = BorderStroke(
                        width = 1.dp,
                        color = Slate300
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(SpaceMedium),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val dailyReward = listOf(1, 2, 3, 5, 10)
                        LazyRow(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            items(dailyReward.size) { reward ->
                                Card {
                                    Column(
                                        modifier = Modifier
                                            .background(Primary600)
                                            .padding(SpaceSmall),
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Icon(
                                            painter = painterResource(id = R.drawable.coin_icon),
                                            contentDescription = "koin",
                                            modifier = Modifier.size(IconSizeMedium),
                                            tint = Secondary600
                                        )
                                        Spacer(modifier = Modifier.height(SpaceExtraSmall))
                                        Text(
                                            text = reward.toString(),
                                            style = MaterialTheme.typography.body1.copy(
                                                color = Color.White
                                            )
                                        )
                                    }
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(SpaceMedium))
                        CustomButton(
                            modifier = Modifier
                                .fillMaxWidth(),
                            onClick = {}
                        ) {
                            Text(
                                text = "Klaim", style = MaterialTheme.typography.body1.copy(
                                    color = Color.White
                                )
                            )
                        }
                    }
                }
            }
        }
        CustomButton(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .offset(y = -SpaceUltraLarge),
            onClick = {
                viewModel.logout()
                navController.navigate(Screen.OnBoardingScreen.route) {
                    popUpTo(0)
                }
            }
        ) {
            Text(
                text = stringResource(R.string.logout),
                style = MaterialTheme.typography.body1.copy(
                    color = Color.White
                )
            )
        }
    }
}