package com.daffa.batur.presentation.quiz.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.IconButton
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
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
import com.daffa.batur.presentation.ui.theme.SpaceExtraSmall
import com.daffa.batur.presentation.ui.theme.SpaceSmall

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun QuizTopBanner(
    navController: NavController,
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    pageSize: Int,
    course: Course,
    currentHealth: Int
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
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                LinearProgressIndicator(
                    color = Primary600,
                    backgroundColor = Slate200,
                    progress = pagerState.currentPage.toFloat() / pageSize.toFloat(),
                    strokeCap = StrokeCap.Round
                )
            }
            Spacer(modifier = Modifier.height(SpaceSmall))
            Text(
                text = course.subBab.toString(),
                style = MaterialTheme.typography.body2.copy(
                    color = Slate900
                )
            )
        }
        HealthSection(
            modifier = Modifier
                .fillMaxWidth(0.6f),
            currentHealth = currentHealth
        )
    }
}