package com.vchepyolkin.whattoplaytoday.data.repository

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.vchepyolkin.whattoplaytoday.common.Constants
import com.vchepyolkin.whattoplaytoday.data.remote.TwitchApi
import com.vchepyolkin.whattoplaytoday.domain.repository.OAuthRepository

class OAuthRepositoryImpl(
    private val api: TwitchApi,
    private val app: Application,
) : OAuthRepository {

    var credentials: SharedPreferences = app.getSharedPreferences("credentials", MODE_PRIVATE)

    override suspend fun getToken(): String {
        return if (credentials.contains("token")) {
            credentials.getString("token", "").toString()
        } else {
            credentials.edit().putString(
                "token", api.getToken(
                    Constants.BASE_AUTH_URL,
                    Constants.CLIENT_ID,
                    Constants.CLIENT_SECRET,
                    Constants.GRANT_TYPE
                ).body()?.access_token
            ).apply()
            credentials.getString("token", "").toString()
        }
    }
}