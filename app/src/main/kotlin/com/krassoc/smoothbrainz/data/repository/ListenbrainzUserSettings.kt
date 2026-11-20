package com.krassoc.smoothbrainz.data.repository

import android.content.Context
import androidx.core.content.edit
import javax.inject.Singleton
import kotlin.time.Clock
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

import com.krassoc.smoothbrainz.model.data.UserSettingsLB
import com.krassoc.smoothbrainz.model.repo.IListenbrainzUserSettings

@Singleton
class ListenbrainzUserSettings (
    private val context: Context
) : IListenbrainzUserSettings {
    private val prefs = context.getSharedPreferences("_listenbrainzSettings", Context.MODE_PRIVATE)
    private val _settingsFlow = MutableStateFlow<UserSettingsLB>(loadSettings())
    override val userSettings: Flow<UserSettingsLB> = _settingsFlow.asStateFlow()
    private fun loadSettings(): UserSettingsLB {
        val listenBrainzToken    = prefs.getString("listenBrainzToken", null)
        val listenBrainzUsername = prefs.getString("listenBrainzUsername", null)
        return UserSettingsLB(
            listenBrainzToken,
            listenBrainzUsername,
            null,
            null,
            null
        )
    }
    override fun setListenBrainzUserAccount(listenBrainzToken: String, listenBrainzUsername: String) {
        if ( (!listenBrainzToken.equals(_settingsFlow.value.listenBrainzToken)) || (!listenBrainzUsername.equals(_settingsFlow.value.listenBrainzUsername))) {
            _settingsFlow.value = UserSettingsLB(
                listenBrainzToken,
                listenBrainzUsername,
                null,
                null,
                null
            )
            prefs.edit { putString("listenBrainzToken", listenBrainzToken) }
            prefs.edit { putString("listenBrainzUsername", listenBrainzUsername) }
        }
    }
    override fun updateListenBrainzRateLimit(remaining: Int, limit: Int, reset: Long, resetIn: Int) {
        val ratelimitReset2 = reset*1000

        val now             = Clock.System.now().toEpochMilliseconds()
        val ratelimitReset1 = now + (resetIn * 1000)

        _settingsFlow.value = UserSettingsLB(
            _settingsFlow.value.listenBrainzToken,
            _settingsFlow.value.listenBrainzUsername,
            remaining,
            limit,
            ratelimitReset1
        )
    }
}
