package com.vchepyolkin.whattoplaytoday.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteGameEntity (
    @PrimaryKey val id: Int,
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