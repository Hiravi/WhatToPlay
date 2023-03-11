package com.vchepyolkin.whattoplaytoday.domain.repository

interface OAuthRepository {

    suspend fun getToken() : String
}