package com.daffa.batur.presentation.splash

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daffa.batur.data.repository.UserRepositoryImpl
import com.daffa.batur.presentation.util.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: UserRepositoryImpl,
) : ViewModel() {

    private val _nextDestination = mutableStateOf(Screen.OnBoardingScreen.route)
    val nextDestination: State<String> = _nextDestination

    init {
        viewModelScope.launch {
            repository.readOnBoardingState().collect { isCompleted ->
                _nextDestination.value =
                    if (isCompleted) Screen.LoginScreen.route else Screen.OnBoardingScreen.route
            }
        }
    }
}