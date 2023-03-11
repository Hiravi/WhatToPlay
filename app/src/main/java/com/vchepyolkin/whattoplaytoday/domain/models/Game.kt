package com.vchepyolkin.whattoplaytoday.domain.models

data class Game(
    val ageRatings: List<Int>,
    val artworksUrl: List<String>,
    val coverUrl: String,
    val follows: Int,
    val genres: List<String>,
    val name: String,
    val rating: Double,
    val summary: String,
    val videoIDs: List<String>,
)