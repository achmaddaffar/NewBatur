package com.daffa.batur.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.daffa.batur.data.repository.UserRepositoryImpl
import com.daffa.batur.presentation.util.states.CustomTextFieldState

class LoginViewModel(
    repository: UserRepositoryImpl
) : ViewModel() {

    private val _usernameText = mutableStateOf(CustomTextFieldState())
    val usernameText: State<CustomTextFieldState> = _usernameText

    private val _passwordText = mutableStateOf(CustomTextFieldState())
    val passwordText: State<CustomTextFieldState> = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    fun setUsernameText(state: CustomTextFieldState) {
        _usernameText.value = state
    }

    fun setPasswordText(state: CustomTextFieldState) {
        _passwordText.value = state
    }

    fun setShowPassword(showPassword: Boolean) {
        _showPassword.value = showPassword
    }

    fun isFieldFilled(): Boolean {
        return usernameText.value.text.isNotEmpty() && passwordText.value.text.isNotEmpty()
    }
}