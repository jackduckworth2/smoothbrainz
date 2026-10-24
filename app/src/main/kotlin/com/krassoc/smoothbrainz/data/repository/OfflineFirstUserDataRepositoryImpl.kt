package com.krassoc.smoothbrainz.data.repository

import kotlinx.coroutines.flow.Flow

import com.krassoc.smoothbrainz.data.services.local.SharedPreferencesService
import com.krassoc.smoothbrainz.model.data.UserData
import com.krassoc.smoothbrainz.model.data.ThemeBrand
import com.krassoc.smoothbrainz.model.data.DarkThemeConfig
import com.krassoc.smoothbrainz.model.repo.IUserDataRepository

class OfflineFirstUserDataRepositoryImpl(
    private val preferencesDataSource: SharedPreferencesService,
) : IUserDataRepository {

    override val userData: Flow<UserData> =
        preferencesDataSource.userData

    override suspend fun setThemeBrand(themeBrand: ThemeBrand) {
        preferencesDataSource.setThemeBrand(themeBrand)
    }

    override suspend fun setDarkThemeConfig(darkThemeConfig: DarkThemeConfig) {
        preferencesDataSource.setDarkThemeConfig(darkThemeConfig)
    }

    override suspend fun setDynamicColorPreference(useDynamicColor: Boolean) {
        preferencesDataSource.setDynamicColorPreference(useDynamicColor)
    }

    override suspend fun setShouldHideOnboarding(shouldHideOnboarding: Boolean) {
        preferencesDataSource.setShouldHideOnboarding(shouldHideOnboarding)
    }
}
