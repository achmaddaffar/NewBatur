package com.daffa.batur.presentation.quiz

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import androidx.wear.compose.material.Text
import com.daffa.batur.R
import com.daffa.batur.data.DataDummy
import com.daffa.batur.data.models.Course
import com.daffa.batur.data.models.Quiz
import com.daffa.batur.presentation.components.CustomButton
import com.daffa.batur.presentation.quiz.components.QuizTopBanner
import com.daffa.batur.presentation.ui.theme.Red
import com.daffa.batur.presentation.ui.theme.RedDark
import com.daffa.batur.presentation.ui.theme.RedLight
import com.daffa.batur.presentation.ui.theme.Slate200
import com.daffa.batur.presentation.ui.theme.Slate25
import com.daffa.batur.presentation.ui.theme.Slate600
import com.daffa.batur.presentation.ui.theme.SpaceLarge
import com.daffa.batur.presentation.ui.theme.SpaceUltraLarge
import com.daffa.batur.presentation.util.Screen
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber

@OptIn(ExperimentalFoundationApi::class, ExperimentalLayoutApi::class)
@Composable
fun QuizScreen(
    navController: NavController,
    viewModel: QuizViewModel = koinViewModel(),
) {
    val coroutineScope = rememberCoroutineScope()
    val quiz = viewModel.getQuiz()
    val health = viewModel.health

    val course = Course(
        subBab = "Tarian Daerah Suku Sunda"
    )
    val pagerState = rememberPagerState()
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        QuizTopBanner(
            navController = navController,
            pagerState = pagerState,
            course = course,
            pageSize = quiz.size,
            modifier = Modifier
                .fillMaxWidth(),
            currentHealth = health.value
        )
        if (health.value > 0)
            HorizontalPager(
                state = pagerState,
                userScrollEnabled = false,
                pageCount = 1
            ) { page ->
                val currentQuiz = quiz[pagerState.currentPage]
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(SpaceLarge)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopCenter),
                    ) {
                        Spacer(modifier = Modifier.height(SpaceLarge))
                        Text(
                            text = currentQuiz.question,
                            style = MaterialTheme.typography.h1,
                            textAlign = TextAlign.Start
                        )
                        if (quiz[pagerState.currentPage].image != null)
                            currentQuiz.image?.let {
                                Image(
                                    painter = painterResource(id = it),
                                    contentDescription = "Gambar soal",
                                    alignment = Alignment.Center,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.width(screenWidth)
                                )
                            }
                    }
                    FlowRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center)
                            .offset(y = SpaceUltraLarge + SpaceLarge),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        maxItemsInEachRow = 3
                    ) {
                        for (option in currentQuiz.options) {
                            CustomButton(
                                buttonColor = Slate25,
                                shadowColor = Slate200,
                                onClick = {}
                            ) {
                                Text(
                                    text = option,
                                    style = MaterialTheme.typography.body2.copy(
                                        color = Slate600
                                    )
                                )
                            }
                        }
                    }
                    Timber.e("QUIZ CEK JAWABAN UI")
                    CustomButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.BottomCenter),
                        onClick = {
                            // GIMANA CARANYA DAPETIN ANSWERNYA????
                            Timber.e("QUIZ CEK JAWABAN")
                            val result = viewModel.checkAnswer(page, "Wayang")
                            if (result) {
                                Timber.e("QUIZ CEK JAWABAN BENAR")
                                if (page < quiz.size - 1) {
                                    Timber.e("QUIZ SCROLL NEXT PAGE")
                                    coroutineScope.launch {
                                        pagerState.animateScrollToPage(page + 1)
                                    }
                                } else {
                                    navController.popBackStack()
                                }
                            } else {
                                viewModel.decreaseHealth()
                                Timber.e("QUIZ CEK JAWABAN SALAH")
                            }
                        }
                    ) {
                        Text(
                            text = "Cek Jawaban",
                            style = MaterialTheme.typography.body1.copy(
                                color = Color.White
                            )
                        )
                    }
                }
            }
        else
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Dialog(
                    onDismissRequest = {
                        navController.navigate(Screen.HomeScreen.route) {
                            popUpTo(0)
                        }
                    }
                ) {
                    Card {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(RedLight)
                                .padding(SpaceLarge),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Anda Gagal",
                                style = MaterialTheme.typography.body1
                            )
                            Spacer(modifier = Modifier.height(SpaceLarge))
                            CustomButton(
                                modifier = Modifier.fillMaxWidth(),
                                onClick = {
                                    navController.popBackStack()
                                },
                                buttonColor = Red,
                                shadowColor = RedDark,
                            ) {
                                Text(
                                    text = "Kembali",
                                    style = MaterialTheme.typography.body1.copy(
                                        color = Color.White
                                    )
                                )
                            }
                        }
                    }
                }
            }
    }
}