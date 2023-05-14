package com.daffa.batur.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.daffa.batur.presentation.util.states.CustomTextFieldState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(

) : ViewModel() {

    private val _usernameText = mutableStateOf(CustomTextFieldState())
    val usernameText: State<CustomTextFieldState> = _usernameText

    private val _passwordText = mutableStateOf(CustomTextFieldState())
    val passwordText: State<CustomTextFieldState> = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _repeatPasswordText = mutableStateOf(CustomTextFieldState())
    val repeatPasswordText: State<CustomTextFieldState> = _repeatPasswordText

    private val _showRepeatPassword = mutableStateOf(false)
    val showRepeatPassword: State<Boolean> = _showRepeatPassword

    fun setUsernameText(state: CustomTextFieldState) {
        _usernameText.value = state
    }

    fun setPasswordText(state: CustomTextFieldState) {
        _passwordText.value = state
    }

    fun setShowPassword(showPassword: Boolean) {
        _showPassword.value = showPassword
    }

    fun setRepeatPasswordText(state: CustomTextFieldState) {
        _repeatPasswordText.value = state
    }

    fun setShowRepeatPassword(showPassword: Boolean) {
        _showRepeatPassword.value = showPassword
    }

    fun isFieldFilled(): Boolean {
        return usernameText.value.text.isNotEmpty() && passwordText.value.text.isNotEmpty() &&
                repeatPasswordText.value.text.isNotEmpty()
    }
}