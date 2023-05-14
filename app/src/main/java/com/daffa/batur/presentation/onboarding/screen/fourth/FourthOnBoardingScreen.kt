package com.daffa.batur.presentation.onboarding.screen.fourth

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.times
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.daffa.batur.R
import com.daffa.batur.data.models.User
import com.daffa.batur.presentation.components.CustomButton
import com.daffa.batur.presentation.components.SingleSelectionList
import com.daffa.batur.presentation.components.SpeechBubble
import com.daffa.batur.presentation.onboarding.OnBoardingPage
import com.daffa.batur.presentation.ui.theme.MascotSizeLarge
import com.daffa.batur.presentation.ui.theme.SpaceLarge
import com.daffa.batur.presentation.ui.theme.SpaceMedium
import com.daffa.batur.presentation.ui.theme.SpaceSmall
import com.daffa.batur.presentation.util.Screen
import kotlinx.coroutines.CoroutineScope
import okhttp3.internal.format
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FourthOnBoardingScreen(
    navController: NavController,
    pagerState: PagerState,
    page: OnBoardingPage,
    coroutineScope: CoroutineScope,
    viewModel: FourthOnBoardingViewModel = koinViewModel(),
) {
    val user = viewModel.user.collectAsStateWithLifecycle(initialValue = User())
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(
                horizontal = SpaceLarge
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)
        ) {
            Image(
                painter = painterResource(id = R.drawable.batur_mascot_default),
                contentDescription = stringResource(id = R.string.batur_mascot),
                modifier = Modifier
                    .size(MascotSizeLarge)
                    .offset(
                        y = -(SpaceSmall),
                        x = SpaceMedium
                    ),
                alignment = Alignment.Center
            )
            SpeechBubble(
                tailAlignment = page.tailAlignment,
                transX = page.transX,
                transY = page.transY,
                rotZ = page.rotZ,
                flipHorizontally = page.flipHorizontally,
                modifier = Modifier
                    .background(Color.Yellow)
                    .offset(y = -(SpaceLarge))
            ) {
                val chat = page.chat.split(" ")
                val chatFinal = buildAnnotatedString {
                    append(chat[0])
                    append(" ")
                    withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                        append(format(chat[1], user.value.username))
                        append(" ")
                    }
                    for (i in 2 until chat.size) {
                        append(chat[i])
                        append(" ")
                    }
                }
                Text(
                    text = chatFinal,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
            Text(
                text = stringResource(R.string.seluruh_indonesia),
                style = MaterialTheme.typography.body1
            )
            SingleSelectionList(
                options = viewModel.countryOptions,
                onOptionClicked = viewModel::selectionCountryOptionSelected
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            Text(
                text = "Pulau Jawa",
                style = MaterialTheme.typography.body1
            )
            SingleSelectionList(
                options = viewModel.options,
                onOptionClicked = viewModel::selectionOptionSelected
            )
        }
        AnimatedVisibility(
            visible = viewModel.checkOptionsSelected(),
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
        ) {
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        start = SpaceLarge,
                        top = SpaceLarge,
                        end = SpaceLarge,
                        bottom = 2 * SpaceLarge
                    ),
                onClick = {
                    navController.navigate(Screen.HomeScreen.route)
                },
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