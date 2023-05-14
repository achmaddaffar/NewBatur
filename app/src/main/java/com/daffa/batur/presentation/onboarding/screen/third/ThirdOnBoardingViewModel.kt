package com.daffa.batur.presentation.onboarding.screen.third

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daffa.batur.data.repository.UserRepositoryImpl
import com.daffa.batur.presentation.util.states.CustomTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ThirdOnBoardingViewModel @Inject constructor(
    private val repository: UserRepositoryImpl,
) : ViewModel() {

    private val _usernameText = mutableStateOf(CustomTextFieldState())
    val usernameText: State<CustomTextFieldState> = _usernameText

    fun setUsernameText(state: CustomTextFieldState) {
        _usernameText.value = state
    }

    fun saveUser() = viewModelScope.launch {
        repository.saveUsername(
            usernameText.value.text
        )
    }
}