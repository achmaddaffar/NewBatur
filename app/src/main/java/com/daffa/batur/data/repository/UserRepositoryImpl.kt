package com.daffa.batur.data.repository

import android.content.Context
import com.daffa.batur.data.UserPreferences
import com.daffa.batur.data.models.User
import com.daffa.batur.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl(context: Context) : UserRepository {
    private val pref = UserPreferences(context)

    override fun readOnBoardingState() = pref.readOnBoardingState()

    override fun readUser() = pref.readUser()

    override suspend fun saveOnBoardingState(isCompleted: Boolean) = pref.saveOnBoardingState(isCompleted)

    override suspend fun saveUser(user: User) = pref.saveUser(user)

    override suspend fun saveUsername(username: String) = pref.saveUsername(username)
}