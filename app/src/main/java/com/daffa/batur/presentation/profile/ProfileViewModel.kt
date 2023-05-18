package com.daffa.batur.presentation.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.daffa.batur.data.repository.UserRepositoryImpl
import kotlinx.coroutines.launch

class ProfileViewModel(
    private val userRepository: UserRepositoryImpl
): ViewModel() {

    fun logout() = viewModelScope.launch {
        userRepository.logout()
    }
}