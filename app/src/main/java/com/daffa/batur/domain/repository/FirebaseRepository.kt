package com.daffa.batur.domain.repository

import com.daffa.batur.util.Resources
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.flow.Flow

interface FirebaseRepository {

    suspend fun register(
        email: String,
        password: String,
    ): Flow<Resources<FirebaseUser?>>

    suspend fun login(
        email: String,
        password: String,
    ): Flow<Resources<FirebaseUser?>>
}