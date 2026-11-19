package com.krassoc.smoothbrainz.ui.feature1.impl

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
//import kotlinx.coroutines.flow.combine
//import kotlinx.coroutines.flow.flatMapLatest
//import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

import com.krassoc.smoothbrainz.model.repo.IUserDataRepository
import com.krassoc.smoothbrainz.model.services.IListenBrainzAPI

class Feature1ViewModel (
    private val savedStateHandle: SavedStateHandle,
    private val userDataRepository: IUserDataRepository,
    private val lb : IListenBrainzAPI
) : ViewModel() {

    private val shouldShowOnboarding: Flow<Boolean> =
        userDataRepository.userData.map { !it.shouldHideOnboarding }

/*
    val isSyncing = syncManager.isSyncing
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false,
        )

    val feedState: StateFlow<NewsFeedUiState> =
        userNewsResourceRepository.observeAllForFollowedTopics()
            .map(NewsFeedUiState::Success)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = NewsFeedUiState.Loading,
            )
*/
    val onboardingUiState: StateFlow<OnboardingUiState> = shouldShowOnboarding
        .map {
            shouldShowOnboarding ->
            if (shouldShowOnboarding) {
                OnboardingUiState.Shown
            } else {
                OnboardingUiState.NotShown
            }
        }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = OnboardingUiState.Loading,
            )

    fun dismissOnboarding() {
        viewModelScope.launch {
            userDataRepository.setShouldHideOnboarding(true)
        }
        viewModelScope.launch {
            val b = lb.verifyToken("412b6ab7-c3c0-410b-a226-64a1e2e84799")
            b.onSuccess {
                ;
            }
        }
    }
}
