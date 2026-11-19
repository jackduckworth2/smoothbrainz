package com.krassoc.smoothbrainz.model.services

interface IListenBrainzAPI {
    suspend fun verifyToken (token: String) : Result<Boolean>
}
