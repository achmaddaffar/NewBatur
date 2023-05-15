package com.daffa.batur.data.repository

import android.content.Context
import com.daffa.batur.data.UserPreferences
import com.daffa.batur.data.models.User
import com.daffa.batur.domain.repository.UserRepository

class UserRepositoryImpl(
    context: Context
) : UserRepository {

    private val preferences = UserPreferences(context)

    override fun readOnBoardingState() = preferences.readOnBoardingState()

    override fun readUser() = preferences.readUser()

    override suspend fun saveOnBoardingState(isCompleted: Boolean) = preferences.saveOnBoardingState(isCompleted)

    override suspend fun saveUser(user: User) = preferences.saveUser(user)

    override suspend fun saveUsername(username: String) = preferences.saveUsername(username)

    override suspend fun logout() = preferences.logout()

    override suspend fun saveSuku(suku: String) = preferences.saveSuku(suku)
}