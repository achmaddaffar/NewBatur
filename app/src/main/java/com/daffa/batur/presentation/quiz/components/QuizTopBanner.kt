package com.daffa.batur.presentation.quiz.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.wear.compose.material.Icon
import androidx.wear.compose.material.Text
import com.daffa.batur.R
import com.daffa.batur.data.models.Course
import com.daffa.batur.presentation.ui.theme.Primary600
import com.daffa.batur.presentation.ui.theme.Slate200
import com.daffa.batur.presentation.ui.theme.Slate300
import com.daffa.batur.presentation.ui.theme.Slate900
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.PagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun QuizTopBanner(
    navController: NavController,
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    course: Course,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconButton(
            onClick = {
                navController.popBackStack()
            },
            modifier = Modifier
                .fillMaxWidth(0.1f)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.cross_icon),
                contentDescription = "Kembali ke menu utama",
                tint = Slate300
            )
        }
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                HorizontalPagerIndicator(
                    pagerState = pagerState,
                    activeColor = Primary600,
                    inactiveColor = Slate200,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green),

                    )
            }
            Text(
                text = course.subBab.toString(),
                style = MaterialTheme.typography.body2.copy(
                    color = Slate900
                )
            )
        }
        HealthSection(
            modifier = Modifier
                .fillMaxWidth(0.6f)
        )
    }
}