package com.daffa.batur.presentation.onboarding.screen.landing

import android.content.pm.ActivityInfo
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.daffa.batur.R
import com.daffa.batur.presentation.components.CustomButton
import com.daffa.batur.presentation.components.LockScreenOrientation
import com.daffa.batur.presentation.ui.theme.Primary600
import com.daffa.batur.presentation.ui.theme.SpaceExtraLarge
import com.daffa.batur.presentation.ui.theme.SpaceLarge
import com.daffa.batur.presentation.ui.theme.SpaceMedium
import com.daffa.batur.presentation.ui.theme.SpaceUltraLarge
import com.daffa.batur.presentation.util.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LandingScreen(
    navController: NavController,
    pagerState: PagerState,
    coroutineScope: CoroutineScope,
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(SpaceLarge)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.Center)
                .offset(y = -SpaceUltraLarge),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = painterResource(id = R.drawable.batur_logo),
                contentDescription = stringResource(id = R.string.batur_logo),
                tint = Primary600
            )
            Spacer(modifier = Modifier.height(SpaceMedium))
            Text(
                text = stringResource(R.string.budaya_tradisi_dan_kultur),
                style = MaterialTheme.typography.body1
            )
            Text(
                text = stringResource(R.string.indonesia_yang_lebih_menyenangkan),
                style = MaterialTheme.typography.body1
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(
                    start = SpaceLarge,
                    end = SpaceLarge,
                    bottom = SpaceLarge
                )
        ) {
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth(),
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                }
            ) {
                Text(
                    text = stringResource(R.string.mari_kita_mulai),
                    style = MaterialTheme.typography.body1.copy(
                        color = Color.White
                    )
                )
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            OutlinedButton(
                onClick = {
                    navController.navigate(Screen.LoginScreen.route)
                },
                modifier = Modifier.fillMaxWidth(),
                border = BorderStroke(
                    width = 1.dp,
                    color = Primary600
                ),
                shape = MaterialTheme.shapes.medium,
                contentPadding = PaddingValues(SpaceMedium)
            ) {
                Text(
                    text = stringResource(R.string.saya_sudah_memiliki_akun),
                    style = MaterialTheme.typography.body1.copy(
                        color = Primary600,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}