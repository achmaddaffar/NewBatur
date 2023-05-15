package com.daffa.batur.domain.repository

import com.daffa.batur.data.models.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun readOnBoardingState(): Flow<Boolean>

    fun readUser(): Flow<User>

    suspend fun saveOnBoardingState(isCompleted: Boolean)

    suspend fun saveUser(user: User)

    suspend fun saveUsername(username: String)

    suspend fun saveSuku(suku: String)

    suspend fun logout()

}