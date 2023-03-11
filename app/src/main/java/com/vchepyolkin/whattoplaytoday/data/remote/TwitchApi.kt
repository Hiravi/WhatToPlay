package com.vchepyolkin.whattoplaytoday.data.remote

import com.vchepyolkin.whattoplaytoday.data.remote.dto.AccessTokenDto
import com.vchepyolkin.whattoplaytoday.data.remote.dto.GameDto
import retrofit2.Response
import retrofit2.http.*

interface TwitchApi {

    @POST
    suspend fun getToken (
        @Url authUrl: String,
        @Query("client_id") clientId: String,
        @Query("client_secret") clientSecret: String,
        @Query("grant_type") grantType: String,
    ) : Response<AccessTokenDto>

    @POST
    suspend fun getGameList(
        @Header("Client-ID") clientId: String,
        @Header("Authorization") accessToken: String,
        @Body body: String,
    ) : List<GameDto>
}