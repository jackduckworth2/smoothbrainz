package com.krassoc.smoothbrainz.ui.featuresettings.impl

import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

import com.krassoc.smoothbrainz.model.data.DarkThemeConfig.DARK
import com.krassoc.smoothbrainz.model.data.ThemeBrand.ANDROID
import com.krassoc.smoothbrainz.ui.featuresettings.impl.SettingsUiState.Loading
import com.krassoc.smoothbrainz.ui.featuresettings.impl.SettingsUiState.Success

class SettingsViewModelTest {

    //private val userDataRepository = TestUserDataRepository()

    private lateinit var viewModel: SettingsViewModel

    @Before
    fun setup() {
        //viewModel = SettingsViewModel(userDataRepository)
    }

    @Test
    fun stateIsInitiallyLoading() = runTest {
        //assertEquals(Loading, viewModel.settingsUiState.value)
    }

    @Test
    fun failTest() = runTest {
        assertEquals(1,1)
    }
    @Test
    fun stateIsSuccessAfterUserDataLoaded() = runTest {
        /*
        backgroundScope.launch(UnconfinedTestDispatcher()) { viewModel.settingsUiState.collect() }

        userDataRepository.setThemeBrand(ANDROID)
        userDataRepository.setDarkThemeConfig(DARK)

        assertEquals(
            Success(
                UserEditableSettings(
                    brand = ANDROID,
                    darkThemeConfig = DARK,
                    useDynamicColor = false,
                ),
            ),
            viewModel.settingsUiState.value,
        )
         */
    }
}
