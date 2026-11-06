package com.krassoc.smoothbrainz.model.services

import kotlinx.coroutines.flow.Flow

import com.krassoc.smoothbrainz.model.data.DarkThemeConfig
import com.krassoc.smoothbrainz.model.data.ThemeBrand
import com.krassoc.smoothbrainz.model.data.UserData

interface ISharedPreferencesService {
    val userData: Flow<UserData>

    fun setThemeBrand(themeBrand: ThemeBrand)

    fun setDynamicColorPreference(useDynamicColor: Boolean)

    fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig)

    fun setShouldHideOnboarding(shouldHideOnboarding: Boolean)
}
