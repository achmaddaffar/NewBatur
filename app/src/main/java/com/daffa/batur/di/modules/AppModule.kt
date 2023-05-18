package com.daffa.batur.di.modules

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.daffa.batur.data.repository.FirebaseRepositoryImpl
import com.daffa.batur.data.repository.QuizRepositoryImpl
import com.daffa.batur.data.repository.UserRepositoryImpl
import com.daffa.batur.util.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import io.grpc.android.BuildConfig
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.dsl.module
import timber.log.Timber

val appModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
    single { provideUserPreferences(get()) }
    single { provideUserRepository(get()) }
    single { FirebaseRepositoryImpl(get(), get()) }
    single { QuizRepositoryImpl() }
}

fun provideUserPreferences(
    context: Context,
): DataStore<Preferences> = PreferenceDataStoreFactory.create(
    corruptionHandler = ReplaceFileCorruptionHandler(
        produceNewData = { emptyPreferences() }
    ),
    migrations = listOf(SharedPreferencesMigration(context, Constants.USER_PREFERENCES_NAME)),
    scope = CoroutineScope(Dispatchers.IO + SupervisorJob()),
    produceFile = { context.preferencesDataStoreFile(Constants.USER_PREFERENCES_NAME) }
)


fun provideUserRepository(
    context: Context,
) = UserRepositoryImpl(context)