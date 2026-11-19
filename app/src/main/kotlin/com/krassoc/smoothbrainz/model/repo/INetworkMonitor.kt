package com.krassoc.smoothbrainz.model.repo

import io.ktor.client.HttpClient
import kotlinx.coroutines.flow.Flow

/**
 * Utility for reporting app connectivity status
 */
interface INetworkMonitor {
    val isOnline: Flow<Boolean>
    val httpClient: HttpClient
}
