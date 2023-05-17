package com.daffa.batur.presentation.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.Text
import com.daffa.batur.R
import com.daffa.batur.data.models.Course
import com.daffa.batur.presentation.home.components.ContinueCourseCard
import com.daffa.batur.presentation.home.components.FeedbackCard
import com.daffa.batur.presentation.home.components.QuickActionCard
import com.daffa.batur.presentation.home.components.StartNewCourseCard
import com.daffa.batur.presentation.home.components.TopBanner
import com.daffa.batur.presentation.ui.theme.SpaceLarge
import com.daffa.batur.presentation.ui.theme.SpaceMedium
import com.daffa.batur.presentation.ui.theme.SpaceSmall
import com.daffa.batur.presentation.ui.theme.SpaceUltraLarge
import com.daffa.batur.presentation.util.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(
    navController: NavController,
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val bannerHeight = (screenWidth / 1.7f)
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(SpaceLarge)
        ) {
            item {
                Spacer(modifier = Modifier.height(bannerHeight))
            }
            item {
                Text(
                    text = stringResource(R.string.aksi_cepat),
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(SpaceSmall))
                QuickActionCard(
                    modifier = Modifier.fillMaxWidth(),
                    course = Course(
                        "Suku Sunda",
                        "Unit 1 - Pengenalan",
                        "Pelajaran 1 - Apa itu Sunda?"
                    )
                ) {
                    navController.navigate(Screen.QuizScreen.route)
                }
                Spacer(modifier = Modifier.height(SpaceMedium))
            }
            item {
                Text(
                    text = stringResource(R.string.kursus),
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(SpaceSmall))
                ContinueCourseCard(
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                StartNewCourseCard(
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
            }
            item {
                Text(
                    text = stringResource(R.string.berikan_ulasan),
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.height(SpaceSmall))
                FeedbackCard(
                    modifier = Modifier.fillMaxWidth()
                )
            }
            item {
                Spacer(modifier = Modifier.height(SpaceUltraLarge + SpaceLarge))
            }
        }
        Column(
            modifier = Modifier.align(Alignment.TopCenter)
        ) {
            TopBanner(
                modifier = Modifier.height(bannerHeight),
                createAccountButtonOnClick = {
                    navController.navigate(Screen.RegisterScreen.route)
                }
            )
        }
    }
}