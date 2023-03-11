package com.vchepyolkin.whattoplaytoday.presentation

sealed class AgeRatings {
    object EarlyChildhood : AgeRatings()
    object Everyone : AgeRatings()
    object Everyone10 : AgeRatings()
    object Teen : AgeRatings()
    object Mature : AgeRatings()
    object AdultsOnly : AgeRatings()
}