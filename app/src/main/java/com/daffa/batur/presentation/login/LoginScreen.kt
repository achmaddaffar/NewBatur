package com.daffa.batur.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.navigation.NavController
import com.daffa.batur.R
import com.daffa.batur.presentation.components.CustomButton
import com.daffa.batur.presentation.components.CustomTextField
import com.daffa.batur.presentation.components.SpeechBubble
import com.daffa.batur.presentation.ui.theme.IconSizeLarge
import com.daffa.batur.presentation.ui.theme.MascotSizeLarge
import com.daffa.batur.presentation.ui.theme.SpaceLarge
import com.daffa.batur.presentation.ui.theme.SpaceMedium
import com.daffa.batur.presentation.ui.theme.SpaceSmall
import com.daffa.batur.presentation.util.Screen
import com.daffa.batur.presentation.util.states.CustomTextFieldState
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = koinViewModel(),
) {

    Column(
        modifier = Modifier
            .background(Color.White)
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
            Icon(
                painter = painterResource(id = R.drawable.back_icon),
                contentDescription = stringResource(
                    R.string.back_icon
                ),
                modifier = Modifier
                    .size(IconSizeLarge)
                    .clickable {
                        navController.popBackStack()
                    }
            )
        }
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
                            y = -SpaceSmall,
                            x = SpaceMedium
                        ),
                    alignment = Alignment.Center
                )
                SpeechBubble(
                    tailAlignment = Alignment.TopStart,
                    transY = -80f,
                    transX = 30f,
                    rotZ = 180f,
                    flipHorizontally = false,
                    modifier = Modifier.offset(
                        y = -SpaceLarge,
                        x = SpaceSmall
                    )
                ) {
                    val chat = buildAnnotatedString {
                        append("Selamat datang kembali! Silahkan ")
                        withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("LOGIN")
                        }
                        append("\n")
                        append("untuk melanjutkan")
                    }
                    Text(
                        text = chat,
                        style = MaterialTheme.typography.body1,
                        textAlign = TextAlign.Center
                    )
                }
            }
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    text = stringResource(R.string.email),
                    style = MaterialTheme.typography.body1
                )
                Spacer(modifier = Modifier.height(SpaceSmall))
                CustomTextField(
                    fieldColor = Color.White,
                    onValueChange = {
                        viewModel.setUsernameText(
                            CustomTextFieldState(
                                text = it
                            )
                        )
                    },
                    text = viewModel.usernameText.value.text,
                    error = viewModel.usernameText.value.error,
                    hint = stringResource(R.string.email_hint),
                    leadingIcon = painterResource(id = R.drawable.email_icon),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(SpaceMedium))
                Text(
                    text = stringResource(R.string.password),
                    style = MaterialTheme.typography.body1
                )
                Spacer(modifier = Modifier.height(SpaceSmall))
                CustomTextField(
                    fieldColor = Color.White,
                    onValueChange = {
                        viewModel.setPasswordText(
                            CustomTextFieldState(
                                text = it
                            )
                        )
                    },
                    text = viewModel.passwordText.value.text,
                    error = viewModel.passwordText.value.error,
                    hint = stringResource(R.string.password_hint),
                    leadingIcon = painterResource(id = R.drawable.password_icon),
                    keyboardType = KeyboardType.Password,
                    showPasswordToggle = viewModel.showPassword.value,
                    onPasswordToggleClick = {
                        viewModel.setShowPassword(it)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(
                        start = SpaceLarge,
                        end = SpaceLarge,
                        bottom = SpaceLarge * 2
                    ),
                onClick = {
                    navController.popBackStack()
                    navController.navigate(Screen.HomeScreen.route) {
                        popUpTo(0)
                    }
                },
                enabled = viewModel.isFieldFilled()
            ) {
                Text(
                    text = "Ayo mulai!",
                    style = MaterialTheme.typography.body1.copy(
                        color = Color.White
                    )
                )
            }
        }
    }
}