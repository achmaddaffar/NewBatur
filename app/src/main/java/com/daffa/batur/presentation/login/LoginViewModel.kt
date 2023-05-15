package com.daffa.batur.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daffa.batur.data.models.User
import com.daffa.batur.data.repository.FirebaseRepositoryImpl
import com.daffa.batur.data.repository.UserRepositoryImpl
import com.daffa.batur.presentation.util.states.CustomTextFieldState
import com.daffa.batur.util.Constants.Empty
import com.daffa.batur.util.Resources
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class LoginViewModel(
    private val userRepository: UserRepositoryImpl,
    private val firebaseRepository: FirebaseRepositoryImpl,
) : ViewModel() {

    private val _usernameText = mutableStateOf(CustomTextFieldState())
    val usernameText: State<CustomTextFieldState> = _usernameText

    private val _passwordText = mutableStateOf(CustomTextFieldState())
    val passwordText: State<CustomTextFieldState> = _passwordText

    private val _showPassword = mutableStateOf(false)
    val showPassword: State<Boolean> = _showPassword

    private val _loginState = MutableStateFlow<Resources<FirebaseUser?>>(Resources.Nothing())
    val loginState = _loginState.asStateFlow()

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

    private fun isPasswordValid(): Boolean {
        val isMoreThan8Chars = passwordText.value.text.length >= 8
        if (!isMoreThan8Chars) {
            setPasswordText(
                CustomTextFieldState(
                    text = passwordText.value.text,
                    error = "Password harus lebih dari 8 karakter"
                )
            )
            return false
        }
        return true
    }

    fun login(email: String, password: String) {
        if (isPasswordValid())
            viewModelScope.launch {
                firebaseRepository.login(
                    email,
                    password
                ).collect {
                    _loginState.value = it
                }
            }
    }

    fun saveOnBoardingState(isCompleted: Boolean) {
        viewModelScope.launch {
            userRepository.saveOnBoardingState(isCompleted)
        }
    }

    fun insertUser() {
        var user = User()
        viewModelScope.launch {
            userRepository.readUser().collectLatest {
                user = it
            }
            firebaseRepository.insertUser(
                User(
                    username = user.username,
                    suku = user.suku
                )
            )
        }
    }
}