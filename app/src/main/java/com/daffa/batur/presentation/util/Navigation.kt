package com.daffa.batur.presentation.util

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.daffa.batur.presentation.home.HomeScreen
import com.daffa.batur.presentation.login.LoginScreen
import com.daffa.batur.presentation.game_map.GameMapScreen
import com.daffa.batur.presentation.onboarding.OnBoardingScreen
import com.daffa.batur.presentation.profile.ProfileScreen
import com.daffa.batur.presentation.register.RegisterScreen
import com.daffa.batur.presentation.splash.SplashScreen

@Composable
fun Navigation(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.GameMapScreen.route,
        modifier = Modifier.fillMaxSize()
    ) {
        composable(Screen.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(Screen.OnBoardingScreen.route) {
            OnBoardingScreen(navController = navController)
        }
        composable(Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(Screen.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
        composable(Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(Screen.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }
        composable(Screen.GameMapScreen.route) {
            GameMapScreen(navController = navController)
        }
    }
}