package com.krassoc.smoothbrainz.model.repo

import kotlinx.coroutines.flow.Flow
import com.krassoc.smoothbrainz.model.data.UserSettingsLB
interface IListenbrainzUserSettings {
    val userSettings: Flow<UserSettingsLB>
    fun setListenBrainzUserAccount(listenBrainzToken: String, listenBrainzUsername: String)
    fun updateListenBrainzRateLimit(remaining: Int, limit: Int, reset: Long, resetIn: Int)
}
