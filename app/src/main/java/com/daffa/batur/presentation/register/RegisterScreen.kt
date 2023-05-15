package com.daffa.batur.presentation.register

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.daffa.batur.R
import com.daffa.batur.presentation.components.CustomButton
import com.daffa.batur.presentation.components.CustomTextField
import com.daffa.batur.presentation.components.SpeechBubble
import com.daffa.batur.presentation.ui.theme.IconSizeLarge
import com.daffa.batur.presentation.ui.theme.IconSizeUltra
import com.daffa.batur.presentation.ui.theme.MascotSizeLarge
import com.daffa.batur.presentation.ui.theme.SpaceLarge
import com.daffa.batur.presentation.ui.theme.SpaceMedium
import com.daffa.batur.presentation.ui.theme.SpaceSmall
import com.daffa.batur.presentation.util.Screen
import com.daffa.batur.presentation.util.states.CustomTextFieldState
import com.daffa.batur.util.Resources
import org.koin.androidx.compose.koinViewModel

@Composable
fun RegisterScreen(
    navController: NavController,
    viewModel: RegisterViewModel = koinViewModel(),
) {
    val uiState by viewModel.registerState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = SpaceLarge
                )
                .verticalScroll(rememberScrollState())
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
                Text(
                    text = stringResource(R.string.register_speech_chat),
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(SpaceMedium))
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
            Spacer(modifier = Modifier.height(SpaceMedium))
            Text(
                text = stringResource(R.string.ketik_ulang_password),
                style = MaterialTheme.typography.body1
            )
            Spacer(modifier = Modifier.height(SpaceSmall))
            CustomTextField(
                fieldColor = Color.White,
                onValueChange = {
                    viewModel.setRepeatPasswordText(
                        CustomTextFieldState(
                            text = it
                        )
                    )
                },
                text = viewModel.repeatPasswordText.value.text,
                error = viewModel.repeatPasswordText.value.error,
                hint = stringResource(R.string.password_hint),
                leadingIcon = painterResource(id = R.drawable.password_icon),
                keyboardType = KeyboardType.Password,
                showPasswordToggle = viewModel.showRepeatPassword.value,
                onPasswordToggleClick = {
                    viewModel.setShowRepeatPassword(it)
                },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
        Box(Modifier.fillMaxSize()) {
            CustomButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(
                        start = SpaceLarge,
                        end = SpaceLarge,
                        bottom = SpaceLarge * 2
                    ),
                onClick = viewModel::register,
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

    when (uiState) {
        is Resources.Loading -> {
            Dialog(
                onDismissRequest = {}
            ) {
                CircularProgressIndicator(
                    modifier = Modifier.size(IconSizeUltra)
                )
            }
        }

        is Resources.Error -> {
            LaunchedEffect(Unit) {
                viewModel.setUsernameText(
                    CustomTextFieldState(
                        text = viewModel.usernameText.value.text,
                        error = uiState.message.toString()
                    )
                )
            }
        }

        is Resources.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(Screen.LoginScreen.route) {
                    popUpTo(0)
                }
            }
        }

        is Resources.Nothing -> {}
    }
}