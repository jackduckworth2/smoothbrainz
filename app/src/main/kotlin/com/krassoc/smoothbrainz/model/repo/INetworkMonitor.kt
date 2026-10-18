package com.krassoc.smoothbrainz.model.repo

import kotlinx.coroutines.flow.Flow

/**
 * Utility for reporting app connectivity status
 */
interface INetworkMonitor {
    val isOnline: Flow<Boolean>
}
