package com.vchepyolkin.whattoplaytoday.domain.models

import com.vchepyolkin.whattoplaytoday.domain.utils.RequestType

data class ApiRequest(
    val clientId: String,
    val token: String,
    val requestType: RequestType,
    var gameName: String = "",
    val genre: String,
    val ageRating: Int = 17,
    val rating: Double,
)