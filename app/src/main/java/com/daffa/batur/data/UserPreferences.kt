package com.daffa.batur.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.stringPreferencesKey
import com.daffa.batur.data.models.User
import com.daffa.batur.util.Constants.Empty
import com.daffa.batur.util.Constants.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class UserPreferences(context: Context) {

    private object PreferencesKey {
        val onBoardingKey = booleanPreferencesKey(name = "on_boarding_completed")
        val username = stringPreferencesKey(name = "username")
        val token = stringPreferencesKey(name = "token")
    }

    private val dataStore = context.dataStore

    suspend fun saveOnBoardingState(isCompleted: Boolean) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.onBoardingKey] = isCompleted
        }
    }

    suspend fun saveUser(user: User) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.username] = user.username
            preferences[PreferencesKey.token] = user.token
        }
    }

    suspend fun saveUsername(username: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKey.username] = username
        }
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.data.catch { exception ->
            if (exception is IOException)
                emit(emptyPreferences())
            else
                throw exception
        }.map { preferences ->
            val onBoardingState = preferences[PreferencesKey.onBoardingKey] ?: false
            onBoardingState
        }
    }

    fun readUser(): Flow<User> {
        return dataStore.data.catch { exception ->
            if (exception is IOException)
                emit(emptyPreferences())
            else
                throw exception
        }.map { preferences ->
            val user = User(
                username = preferences[PreferencesKey.username] ?: String.Empty,
                token = preferences[PreferencesKey.token] ?: String.Empty
            )
            user
        }
    }
}