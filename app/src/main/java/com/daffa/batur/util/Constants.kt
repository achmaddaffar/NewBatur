package com.daffa.batur.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore

object Constants {
    const val SPLASH_SCREEN_DURATION = 1500L
    const val USER_PREFERENCES_NAME = "user_preferences"
    const val COLLECTION_USERS_NAME = "users"
    const val COLLECTION_QUIZ_NAME = "quizzes"
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = USER_PREFERENCES_NAME)
    val String.Companion.Empty
        inline get() = ""
}