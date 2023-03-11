package com.vchepyolkin.whattoplaytoday.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.vchepyolkin.whattoplaytoday.data.local.entity.GameEntity

data class GameDto(
    @SerializedName("age_ratings") val ageRatings: List<AgeRatingDto>,
    val artworks: List<ArtworkDto>,
    val cover: CoverDto,
    val follows: Int,
    val genres: List<GenreDto>,
    val id: Int,
    val name: String,
    val rating: Double,
    val summary: String,
    val videos: List<VideoDto>,
) {
    fun toGameEntity() : GameEntity {
        return GameEntity(
            id = id,
            ageRatings = ageRatings.map { it.rating },
            artworksUrl = artworks.map { it.url },
            coverUrl = cover.url,
            follows = follows,
            genres = genres.map { it.name },
            name = name,
            rating = rating,
            summary = summary,
            videoIDs = videos.map { it.video_id },
        )
    }
}