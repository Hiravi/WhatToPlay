package com.vchepyolkin.whattoplaytoday.domain.repository

import com.vchepyolkin.whattoplaytoday.common.Resource
import com.vchepyolkin.whattoplaytoday.data.local.entity.FavoriteGameEntity
import com.vchepyolkin.whattoplaytoday.domain.models.ApiRequest
import com.vchepyolkin.whattoplaytoday.domain.models.Game
import kotlinx.coroutines.flow.Flow

interface GameRepository {

    suspend fun getGameList(
        request: ApiRequest,
    ): Flow<Resource<List<Game>>>

    suspend fun getGameListByName(
        request: ApiRequest,
    ): Flow<Resource<List<Game>>>

    suspend fun getFavoriteGames() : Flow<List<FavoriteGameEntity>>
}