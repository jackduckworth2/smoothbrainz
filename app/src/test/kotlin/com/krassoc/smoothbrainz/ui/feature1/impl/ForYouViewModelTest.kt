package com.krassoc.smoothbrainz.ui.feature1.impl

import androidx.lifecycle.SavedStateHandle
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import kotlinx.datetime.Instant
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

import com.krassoc.smoothbrainz.model.data.UserNewsResource

/**
 * To learn more about how this test handles Flows created with stateIn, see
 * https://developer.android.com/kotlin/flow/test#statein
 */
class Feature1ViewModelTest {
    //@get:Rule
    //private val userDataRepository = TestUserDataRepository()
    private val savedStateHandle = SavedStateHandle()
    private lateinit var viewModel: Feature1ViewModel

    @Before
    fun setup() {
        //viewModel = Feature1ViewModel(
        //    savedStateHandle = savedStateHandle,
        //    userDataRepository = userDataRepository,
        //)
    }
/*
    @Test
    fun stateIsInitiallyLoading() = runTest {
        assertEquals(
            OnboardingUiState.Loading,
            viewModel.onboardingUiState.value,
        )
    }

    @Test
    fun stateIsLoadingWhenFollowedTopicsAreLoading() = runTest {
        backgroundScope.launch(UnconfinedTestDispatcher()) { viewModel.onboardingUiState.collect() }
        backgroundScope.launch(UnconfinedTestDispatcher()) { viewModel.feedState.collect() }

        assertEquals(
            OnboardingUiState.Loading,
            viewModel.onboardingUiState.value,
        )
    }

    @Test
    fun stateIsLoadingWhenAppIsSyncingWithNoInterests() = runTest {
        syncManager.setSyncing(true)

        backgroundScope.launch(UnconfinedTestDispatcher()) { viewModel.isSyncing.collect() }

        assertEquals(
            true,
            viewModel.isSyncing.value,
        )
    }

    @Test
    fun onboardingStateIsLoadingWhenTopicsAreLoading() = runTest {
        backgroundScope.launch(UnconfinedTestDispatcher()) { viewModel.onboardingUiState.collect() }
        backgroundScope.launch(UnconfinedTestDispatcher()) { viewModel.feedState.collect() }

        userDataRepository.setFollowedTopicIds(emptySet())

        assertEquals(
            OnboardingUiState.Loading,
            viewModel.onboardingUiState.value,
        )
    }

    @Test
    fun onboardingIsNotShownAfterUserDismissesOnboarding() = runTest {
        backgroundScope.launch(UnconfinedTestDispatcher()) { viewModel.onboardingUiState.collect() }
        backgroundScope.launch(UnconfinedTestDispatcher()) { viewModel.feedState.collect() }

        val followedTopicIds = setOf("0", "1")
        val userData = emptyUserData.copy(followedTopics = followedTopicIds)
        userDataRepository.setUserData(userData)
        viewModel.dismissOnboarding()

        assertEquals(
            OnboardingUiState.NotShown,
            viewModel.onboardingUiState.value,
        )

        assertEquals(
            OnboardingUiState.NotShown,
            viewModel.onboardingUiState.value,
        )
*    }
 */
}

