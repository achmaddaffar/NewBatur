package com.daffa.batur.presentation.register

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daffa.batur.data.repository.FirebaseRepositoryImpl
import com.daffa.batur.data.repository.UserRepositoryImpl
import com.daffa.batur.presentation.util.states.CustomTextFieldState
import com.daffa.batur.util.Resources
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class RegisterViewModel(
    userRepository: UserRepositoryImpl,
    private val firebaseRepository: FirebaseRepositoryImpl,
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

    private val _registerState = MutableStateFlow<Resources<FirebaseUser?>>(Resources.Nothing())
    val registerState = _registerState.asStateFlow()

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
        return usernameText.value.text.isNotEmpty() &&
                passwordText.value.text.isNotEmpty() &&
                repeatPasswordText.value.text.isNotEmpty()
    }

    private fun isPasswordValid(): Boolean {
        val isTheSame = passwordText.value.text == repeatPasswordText.value.text
        val isMoreThan8Chars = passwordText.value.text.length >= 8
        if (!isTheSame) {
            setPasswordText(
                CustomTextFieldState(
                    text = passwordText.value.text,
                    error = "Kedua password harus sama"
                )
            )
            setRepeatPasswordText(
                CustomTextFieldState(
                    text = repeatPasswordText.value.text,
                    error = "Kedua password harus sama"
                )
            )
            return false
        }
        if (!isMoreThan8Chars) {
            setPasswordText(
                CustomTextFieldState(
                    text = passwordText.value.text,
                    error = "Password harus lebih dari 8 karakter"
                )
            )
            setRepeatPasswordText(
                CustomTextFieldState(
                    text = repeatPasswordText.value.text,
                    error = "Password harus lebih dari 8 karakter"
                )
            )
            return false
        }
        return true
    }

    fun register() {
        if (isPasswordValid())
            viewModelScope.launch {
                firebaseRepository.register(
                    usernameText.value.text,
                    passwordText.value.text
                ).collect {
                    _registerState.value = it
                }
            }
    }
}