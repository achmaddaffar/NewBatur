package com.daffa.batur.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.daffa.batur.data.UserPreferences
import com.daffa.batur.data.repository.UserRepositoryImpl
import com.daffa.batur.domain.repository.UserRepository
import com.daffa.batur.presentation.home.HomeViewModel
import com.daffa.batur.presentation.login.LoginViewModel
import com.daffa.batur.presentation.onboarding.screen.fourth.FourthOnBoardingViewModel
import com.daffa.batur.presentation.onboarding.screen.third.ThirdOnBoardingViewModel
import com.daffa.batur.presentation.register.RegisterViewModel
import com.daffa.batur.presentation.splash.SplashViewModel
import com.daffa.batur.util.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { provideUserPreferences(get()) }
    single { provideUserRepository(get()) }

    viewModel { SplashViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { ThirdOnBoardingViewModel(get()) }
    viewModel { FourthOnBoardingViewModel(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { HomeViewModel(get()) }
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
    context: Context
) = UserRepositoryImpl(context)