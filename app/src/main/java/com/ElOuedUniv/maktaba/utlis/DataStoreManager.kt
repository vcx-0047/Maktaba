package com.ElOuedUniv.maktaba.utlis

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "onboarding_prefs")

@Singleton
class DataStoreManager @Inject constructor(
    @param:ApplicationContext private val context: Context,
) {

    companion object {
        private val ON_BOARDING_KEY = booleanPreferencesKey("on_boarding_completed")
    }

    suspend fun setOnBoardingCompleted() {
        context.dataStore.edit { preferences ->
            preferences[ON_BOARDING_KEY] = true
        }
    }

    fun getOnBoarding(): Flow<Boolean> {
        return context.dataStore.data
            .catch { exception ->
                if (exception is IOException) {
                    emit(emptyPreferences())
                } else {
                    throw exception
                }
            }
            .map { preferences ->
                preferences[ON_BOARDING_KEY] ?: false
            }
    }
}
