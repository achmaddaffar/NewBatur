package com.daffa.batur.presentation.quiz

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
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.wear.compose.material.Text
import com.daffa.batur.R
import com.daffa.batur.data.models.Course
import com.daffa.batur.data.models.Quiz
import com.daffa.batur.presentation.components.CustomButton
import com.daffa.batur.presentation.quiz.components.QuizTopBanner
import com.daffa.batur.presentation.ui.theme.Slate200
import com.daffa.batur.presentation.ui.theme.Slate25
import com.daffa.batur.presentation.ui.theme.Slate600
import com.daffa.batur.presentation.ui.theme.SpaceLarge
import com.daffa.batur.presentation.ui.theme.SpaceUltraLarge
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@OptIn(ExperimentalPagerApi::class, ExperimentalLayoutApi::class)
@Composable
fun QuizScreen(
    navController: NavController,
) {
    val coroutineScope = rememberCoroutineScope()

    val quiz = listOf(
        Quiz(
            question = "Manakah di bawah ini yang termasuk tarian daerah Sunda?",
            options = listOf(
                "Wayang",
                "Piring",
                "Kecak",
                "Saman",
                "Topeng"
            ),
            answer = listOf(
                "Wayang"
            )
        ),
        Quiz(
            question = "Tarian Wayang berasal dari",
            options = listOf(
                "Cirebon",
                "Bandung",
                "Bali",
                "Garut",
                "Subang"
            ),
            answer = listOf(
                "Cirebon"
            ),
            image = painterResource(id = R.drawable.tari_wayang)
        ),
    )

    val course = Course(
        subBab = "Tarian Daerah Suku Sunda"
    )
    val pagerState = rememberPagerState(pageCount = quiz.size)
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
            modifier = Modifier
                .fillMaxWidth()
        )
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.padding(SpaceLarge),
            dragEnabled = false
        ) {
            val currentQuiz = quiz[pagerState.currentPage]

            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
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
                                painter = it,
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
                    for (option in currentQuiz.options)
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
                CustomButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
                    onClick = {
                        if (pagerState.currentPage < quiz.size - 1)
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(pagerState.currentPage + 1)
                            }
                        else
                            navController.popBackStack()
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
    }
}