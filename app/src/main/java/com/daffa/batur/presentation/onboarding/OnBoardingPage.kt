package com.daffa.batur.presentation.onboarding

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.daffa.batur.util.Constants.Empty

sealed class OnBoardingPage(
    val tailAlignment: Alignment = Alignment.Center,
    val chat: String = String.Empty,
    val buttonText: String = String.Empty,
    val transX: Float = 0f,
    val transY: Float = 0f,
    val rotZ: Float = 0f,
    val flipHorizontally: Boolean = false,
    val content: @Composable ColumnScope.() -> Unit = {},
) {
    object LandingPage : OnBoardingPage()
    object FirstPage : OnBoardingPage(
        tailAlignment = Alignment.BottomEnd,
        chat = "Halo semuanya! Aku BATUR \nyang akan menemani kalian",
        buttonText = "Lanjutkan",
        transY = 80f,
        transX = -30f,
    )

    object SecondPage : OnBoardingPage(
        tailAlignment = Alignment.BottomStart,
        chat = "Mari kita mulai! Apakah kalian\nsudah siap?",
        buttonText = "Aku siap belajar!",
        transY = 80f,
        transX = 30f,
        flipHorizontally = true
    )

    object ThirdPage : OnBoardingPage(
        tailAlignment = Alignment.TopStart,
        chat = "Sebelum masuk lebih lanjut, bagaimana kami harus memanggilmu?",
        buttonText = "Lanjutkan!",
        transY = -80f,
        transX = 30f,
        rotZ = 180f
    )

    object FourthPage : OnBoardingPage(
        tailAlignment = Alignment.TopStart,
        chat = "Halo, %s! Budaya suku mana yang ingin kamu pelajari?",
        buttonText = "Ayo mulai!",
        transY = -80f,
        transX = 30f,
        rotZ = 180f
    )
}
