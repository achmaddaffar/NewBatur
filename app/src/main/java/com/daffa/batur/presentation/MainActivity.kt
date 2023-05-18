package com.daffa.batur.presentation

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.daffa.batur.presentation.components.CustomScaffold
import com.daffa.batur.presentation.components.LockScreenOrientation
import com.daffa.batur.presentation.ui.theme.BaturTheme
import com.daffa.batur.presentation.ui.theme.Primary600
import com.daffa.batur.presentation.util.Navigation
import com.daffa.batur.presentation.util.Screen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaturTheme {
                val systemUiController = rememberSystemUiController()
                systemUiController.setStatusBarColor(Primary600)

                LockScreenOrientation(orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    CustomScaffold(
                        navController = navController,
                        showBottomBar = navBackStackEntry?.destination?.route in listOf(
                            Screen.HomeScreen.route,
                            Screen.GameMapScreen.route,
                            Screen.ProfileScreen.route
                        ),
                        modifier = Modifier.fillMaxSize(),
                    ) {
                        Navigation(navController = navController)
                    }
                }
            }
        }
    }
}