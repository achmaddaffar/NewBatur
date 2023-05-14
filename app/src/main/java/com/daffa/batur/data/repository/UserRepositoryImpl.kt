package com.daffa.batur.data.repository

import com.daffa.batur.data.models.User
import com.daffa.batur.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class UserRepositoryImpl: UserRepository {
    override fun readOnBoardingState(): Flow<Boolean> {
        TODO("Not yet implemented")
    }

    override fun readUser(): Flow<User> {
        TODO("Not yet implemented")
    }

    override suspend fun saveOnBoardingState(isCompleted: Boolean) {
        TODO("Not yet implemented")
    }

    override suspend fun saveUser(user: User) {
        TODO("Not yet implemented")
    }

    override suspend fun saveUsername(username: String) {
        TODO("Not yet implemented")
    }
}