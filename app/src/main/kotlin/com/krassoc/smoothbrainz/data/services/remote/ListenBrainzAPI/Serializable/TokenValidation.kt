package com.krassoc.smoothbrainz.data.services.remote.ListenBrainzAPI.Serializable

import kotlinx.serialization.Serializable

import com.krassoc.smoothbrainz.model.data.ListenBrainzAPI.TokenValidation

@Serializable
data class TokenValidationSerializable(
    val code: Int = 0,
    val message: String = "",
    val user_name: String? = null,
    val valid: Boolean = false
)

fun TokenValidationSerializable.toEntity() = TokenValidation(
    valid = valid,
    username = user_name
)