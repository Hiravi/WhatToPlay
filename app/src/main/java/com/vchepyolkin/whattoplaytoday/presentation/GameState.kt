package com.vchepyolkin.whattoplaytoday.presentation

import com.vchepyolkin.whattoplaytoday.domain.models.Game

data class GameState(
    val gameItems: List<Game> = emptyList(),
    val isLoading: Boolean = false,
)