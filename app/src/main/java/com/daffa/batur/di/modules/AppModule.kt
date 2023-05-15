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
import com.daffa.batur.data.repository.UserRepositoryImpl
import com.daffa.batur.presentation.home.HomeViewModel
import com.daffa.batur.presentation.login.LoginViewModel
import com.daffa.batur.presentation.onboarding.screen.fourth.FourthOnBoardingViewModel
import com.daffa.batur.presentation.onboarding.screen.third.ThirdOnBoardingViewModel
import com.daffa.batur.presentation.register.RegisterViewModel
import com.daffa.batur.presentation.splash.SplashViewModel
import com.daffa.batur.util.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
    single { provideUserPreferences(get()) }
    single { provideUserRepository(get()) }
    single { FirebaseRepositoryImpl(get(), get()) }
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