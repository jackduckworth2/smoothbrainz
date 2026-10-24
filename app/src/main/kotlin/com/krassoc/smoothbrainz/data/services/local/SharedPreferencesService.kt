package com.krassoc.smoothbrainz.data.services.local

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Singleton

import com.krassoc.smoothbrainz.model.data.DarkThemeConfig
import com.krassoc.smoothbrainz.model.data.ThemeBrand
import com.krassoc.smoothbrainz.model.data.UserData

@Singleton
class SharedPreferencesService (
    private val context: Context
) {
    private val prefs = context.getSharedPreferences("_settings", Context.MODE_PRIVATE)
    private val _settingsFlow = MutableStateFlow(loadSettings())
    val userData: Flow<UserData> = _settingsFlow.asStateFlow()
    private fun loadSettings(): UserData {
        val themeBrand          = prefs.getString("themeBrand", null)?.let {
            try {
                enumValueOf<ThemeBrand>(it)
            } catch (e: IllegalArgumentException) {
                null
            }
        } ?: ThemeBrand.ANDROID
        val darkThemeConfig      = prefs.getString("darkThemeConfig", null)?.let {
            try {
                enumValueOf<DarkThemeConfig>(it)
            } catch (e: IllegalArgumentException) {
                null
            }
        } ?: DarkThemeConfig.FOLLOW_SYSTEM
        val useDynamicColor      = prefs.getBoolean("useDynamicColor",      true)
        val shouldHideOnboarding = prefs.getBoolean("shouldHideOnboarding", false)
        return UserData(
            themeBrand,
            darkThemeConfig,
            useDynamicColor,
            false
        )
    }

    fun setThemeBrand(themeBrand: ThemeBrand) {
        _settingsFlow.value = UserData(
            themeBrand,
            _settingsFlow.value.darkThemeConfig,
            _settingsFlow.value.useDynamicColor,
            _settingsFlow.value.shouldHideOnboarding,
        )
        prefs.edit().putString ("themeBrand", themeBrand.name).apply()
    }

    fun setDynamicColorPreference(useDynamicColor: Boolean) {
        _settingsFlow.value = UserData(
            _settingsFlow.value.themeBrand,
            _settingsFlow.value.darkThemeConfig,
            useDynamicColor,
            _settingsFlow.value.shouldHideOnboarding,
        )
        prefs.edit().putBoolean("useDynamicColor", useDynamicColor).apply()
    }

    fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        _settingsFlow.value = UserData(
            _settingsFlow.value.themeBrand,
            darkThemeConfig,
            _settingsFlow.value.useDynamicColor,
            _settingsFlow.value.shouldHideOnboarding,
        )
        prefs.edit().putString ("darkThemeConfig", darkThemeConfig.name).apply()
    }

    fun setShouldHideOnboarding(shouldHideOnboarding: Boolean) {
        _settingsFlow.value = UserData(
            _settingsFlow.value.themeBrand,
            _settingsFlow.value.darkThemeConfig,
            _settingsFlow.value.useDynamicColor,
            shouldHideOnboarding,
        )
        prefs.edit().putBoolean("shouldHideOnboarding", shouldHideOnboarding).apply()
    }
}
