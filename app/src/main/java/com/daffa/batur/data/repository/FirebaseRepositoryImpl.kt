package com.daffa.batur.data.repository

import android.util.Log
import com.daffa.batur.data.models.User
import com.daffa.batur.domain.repository.FirebaseRepository
import com.daffa.batur.util.Constants
import com.daffa.batur.util.Resources
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await
import timber.log.Timber

class FirebaseRepositoryImpl(
    private val auth: FirebaseAuth,
    private val db: FirebaseFirestore,
) : FirebaseRepository {

    override suspend fun register(
        email: String,
        password: String,
    ): Flow<Resources<FirebaseUser?>> = flow {
        emit(Resources.Loading())
        try {
            val result = auth.createUserWithEmailAndPassword(
                email,
                password
            ).await()
            if (result.user != null)
                emit(Resources.Success(result.user))
            else
                emit(Resources.Error("Error"))
        } catch (e: FirebaseAuthException) {
            emit(Resources.Error(message = e.localizedMessage))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun login(
        email: String,
        password: String,
    ): Flow<Resources<FirebaseUser?>> = flow {
        emit(Resources.Loading())
        try {
            val result = auth.signInWithEmailAndPassword(
                email,
                password
            ).await()
            if (result.user != null)
                emit(Resources.Success(result.user))
            else
                emit(Resources.Error("Error"))
        } catch (e: FirebaseAuthException) {
            emit(Resources.Error(e.message))
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun insertUser(user: User) {
        val uid = auth.currentUser!!.uid
        Timber.tag("UID").e(uid.toString())
        db.collection(Constants.COLLECTION_USERS_NAME)
            .document(uid)
            .set(user)
    }
}