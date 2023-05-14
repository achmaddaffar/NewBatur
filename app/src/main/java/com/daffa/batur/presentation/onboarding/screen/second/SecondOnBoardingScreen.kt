package com.daffa.batur.presentation.onboarding.screen.second

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.daffa.batur.R
import com.daffa.batur.presentation.components.CustomButton
import com.daffa.batur.presentation.components.SpeechBubble
import com.daffa.batur.presentation.onboarding.OnBoardingPage
import com.daffa.batur.presentation.ui.theme.MascotSizeLarge
import com.daffa.batur.presentation.ui.theme.SpaceLarge
import com.daffa.batur.presentation.ui.theme.SpaceSmall
import com.daffa.batur.presentation.ui.theme.SpaceUltraLarge
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SecondOnBoardingScreen(
    navController: NavController,
    pagerState: PagerState,
    coroutineScope: CoroutineScope,
    page: OnBoardingPage,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(SpaceLarge)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(SpaceLarge)
                    .offset(
                        y = -SpaceUltraLarge
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SpeechBubble(
                    tailAlignment = page.tailAlignment,
                    transX = page.transX,
                    transY = page.transY,
                    rotZ = page.rotZ,
                    flipHorizontally = page.flipHorizontally
                ) {
                    Text(
                        text = page.chat,
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Center
                    )
                }
                Image(
                    painter = painterResource(id = R.drawable.batur_mascot_smile),
                    contentDescription = stringResource(R.string.batur_mascot),
                    modifier = Modifier
                        .size(MascotSizeLarge)
                        .offset(y = -SpaceSmall),
                    alignment = Alignment.Center
                )
            }

            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(SpaceLarge),
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            ) {
                Text(
                    text = page.buttonText,
                    style = MaterialTheme.typography.body1.copy(
                        color = Color.White
                    )
                )
            }
        }
    }
}