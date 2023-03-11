package com.vchepyolkin.whattoplaytoday.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.vchepyolkin.whattoplaytoday.domain.models.Game

@Entity
data class GameEntity(
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
) {
    fun toGame() : Game {
        return Game(
            ageRatings = ageRatings,
            artworksUrl = artworksUrl,
            coverUrl = coverUrl,
            follows = follows,
            genres = genres,
            name = name,
            rating = rating,
            summary = summary,
            videoIDs = videoIDs,
        )
    }
}
