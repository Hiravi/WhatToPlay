package com.vchepyolkin.whattoplaytoday.data.remote.dto

data class AccessTokenDto(
    val access_token: String,
    val expires_in: Int,
    val token_type: String
)