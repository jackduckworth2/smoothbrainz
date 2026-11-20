package com.krassoc.smoothbrainz.model.data

/**
 * Class summarizing user listenbrainz account  data
 */
data class UserSettingsLB(
    val listenBrainzToken: String?,
    val listenBrainzUsername: String?,
    val ratelimitRemaining: Int?,
    val ratelimitLimit: Int?,
    val ratelimitReset: Long?, // Epoch millisecs
)
