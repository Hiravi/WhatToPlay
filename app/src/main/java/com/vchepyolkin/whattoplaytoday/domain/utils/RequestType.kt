package com.vchepyolkin.whattoplaytoday.domain.utils

sealed class RequestType {
    object Search : RequestType()
    object List : RequestType()
}
