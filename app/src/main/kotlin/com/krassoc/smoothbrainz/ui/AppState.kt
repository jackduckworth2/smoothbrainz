package com.krassoc.smoothbrainz.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

import com.krassoc.smoothbrainz.model.repo.INetworkMonitor
import com.krassoc.smoothbrainz.ui.feature1.api.Feature1NavKey
import com.krassoc.smoothbrainz.ui.navigation.NavigationState
import com.krassoc.smoothbrainz.ui.navigation.rememberNavigationState
import com.krassoc.smoothbrainz.ui.navigation.TOP_LEVEL_NAV_ITEMS

@Composable
fun rememberAppState(
    networkMonitor: INetworkMonitor,
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
): AppState {
    val navigationState = rememberNavigationState(Feature1NavKey, TOP_LEVEL_NAV_ITEMS.keys)

    return remember(
        navigationState,
        coroutineScope,
        networkMonitor,
    ) {
        AppState(
            navigationState = navigationState,
            coroutineScope = coroutineScope,
            networkMonitor = networkMonitor,
        )
    }
}

@Stable
class AppState(
    val navigationState: NavigationState,
    coroutineScope: CoroutineScope,
    networkMonitor: INetworkMonitor,
) {
    val isOffline = networkMonitor.isOnline
        .map(Boolean::not)
        .stateIn(
            scope = coroutineScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = false,
        )
}
