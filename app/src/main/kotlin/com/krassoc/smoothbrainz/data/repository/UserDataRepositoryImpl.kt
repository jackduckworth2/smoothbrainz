package com.krassoc.smoothbrainz.data.repository

import kotlinx.coroutines.flow.Flow

import com.krassoc.smoothbrainz.model.data.UserData
import com.krassoc.smoothbrainz.model.data.ThemeBrand
import com.krassoc.smoothbrainz.model.data.DarkThemeConfig
import com.krassoc.smoothbrainz.model.repo.IUserDataRepository
import com.krassoc.smoothbrainz.model.services.ISharedPreferencesService

class UserDataRepositoryImpl(
    private val preferencesDataSource: ISharedPreferencesService,
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
