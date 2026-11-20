package com.krassoc.smoothbrainz.model.services

import com.krassoc.smoothbrainz.model.data.ListenBrainzAPI.TokenValidation
interface IListenBrainzAPI {
    suspend fun verifyToken (token: String) : Result<TokenValidation>
}
