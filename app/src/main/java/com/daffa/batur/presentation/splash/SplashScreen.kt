package com.daffa.batur.presentation.splash

import android.content.pm.ActivityInfo
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.daffa.batur.R
import com.daffa.batur.presentation.components.LockScreenOrientation
import com.daffa.batur.presentation.ui.theme.Primary600
import com.daffa.batur.presentation.ui.theme.Secondary600
import com.daffa.batur.presentation.ui.theme.SpaceSmall
import com.daffa.batur.util.Constants
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel

@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel = koinViewModel(),
) {
    LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

    val alpha = remember {
        Animatable(0f)
    }
    val nextDestination by viewModel.nextDestination
    val systemUiController: SystemUiController = rememberSystemUiController()
    systemUiController.isStatusBarVisible = false

    LaunchedEffect(key1 = true) {
        alpha.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 1500
            )
        )
        delay(Constants.SPLASH_SCREEN_DURATION)

        systemUiController.isStatusBarVisible = true
        navController.popBackStack()
        navController.navigate(nextDestination)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Primary600),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(alpha.value),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.batur_logo),
                contentDescription = stringResource(R.string.batur_logo),
                tint = Color.White
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            Text(
                text = stringResource(R.string.budaya_tradisi_dan_kultur),
                style = MaterialTheme.typography.body1.copy(
                    color = Secondary600
                )
            )
        }
    }
}