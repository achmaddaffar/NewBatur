package com.daffa.batur.presentation.onboarding

import android.content.pm.ActivityInfo
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.daffa.batur.R
import com.daffa.batur.presentation.components.LockScreenOrientation
import com.daffa.batur.presentation.onboarding.screen.landing.LandingScreen
import com.daffa.batur.presentation.onboarding.screen.first.FirstOnBoardingScreen
import com.daffa.batur.presentation.onboarding.screen.fourth.FourthOnBoardingScreen
import com.daffa.batur.presentation.onboarding.screen.second.SecondOnBoardingScreen
import com.daffa.batur.presentation.onboarding.screen.third.ThirdOnBoardingScreen
import com.daffa.batur.presentation.ui.theme.IconSizeLarge
import com.daffa.batur.presentation.ui.theme.Slate400
import com.daffa.batur.presentation.ui.theme.SpaceLarge
import com.daffa.batur.presentation.ui.theme.SpaceMedium
import com.daffa.batur.presentation.ui.theme.SpaceSmall
import com.daffa.batur.presentation.util.Screen
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBoardingScreen(
    navController: NavController,
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState()
    val pages = listOf(
        OnBoardingPage.LandingPage,
        OnBoardingPage.FirstPage,
        OnBoardingPage.SecondPage,
        OnBoardingPage.ThirdPage,
        OnBoardingPage.FourthPage
    )

    HorizontalPager(
        pageCount = pages.size,
        state = pagerState,
        userScrollEnabled = false
    ) { page ->
        Column(
            modifier = Modifier.background(Color.White)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = SpaceLarge,
                        vertical = SpaceMedium
                    ),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AnimatedVisibility(
                    visible = page != 0,
                    modifier = Modifier.offset(
                        x = SpaceSmall,
                        y = SpaceSmall
                    )
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.back_icon),
                        contentDescription = stringResource(
                            R.string.back_icon
                        ),
                        modifier = Modifier
                            .size(IconSizeLarge)
                            .clickable {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(pagerState.currentPage - 1)
                                }
                            }
                    )
                }
                AnimatedVisibility(
                    visible = page == pages.size - 1,
                    modifier = Modifier.offset(
                        x = -SpaceSmall,
                        y = SpaceSmall
                    )
                ) {
                    TextButton(
                        onClick = { navController.navigate(Screen.HomeScreen.route) },
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            text = "Lewati",
                            style = MaterialTheme.typography.body2.copy(
                                color = Slate400
                            ),
                            textDecoration = TextDecoration.Underline
                        )
                    }
                }
            }
            when (page) {
                0 -> LandingScreen(
                    navController = navController,
                    pagerState = pagerState,
                    coroutineScope = coroutineScope
                )

                1 -> FirstOnBoardingScreen(
                    navController = navController,
                    pagerState = pagerState,
                    coroutineScope = coroutineScope,
                    page = pages[page]
                )

                2 -> SecondOnBoardingScreen(
                    navController = navController,
                    pagerState = pagerState,
                    coroutineScope = coroutineScope,
                    page = pages[page]
                )

                3 -> ThirdOnBoardingScreen(
                    navController = navController,
                    pagerState = pagerState,
                    coroutineScope = coroutineScope,
                    page = pages[page]
                )

                4 -> FourthOnBoardingScreen(
                    navController = navController,
                    pagerState = pagerState,
                    coroutineScope = coroutineScope,
                    page = pages[page],
                )
            }
        }
    }
}