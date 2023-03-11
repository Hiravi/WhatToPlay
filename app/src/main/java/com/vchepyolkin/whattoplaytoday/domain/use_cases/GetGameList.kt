package com.vchepyolkin.whattoplaytoday.domain.use_cases

import com.vchepyolkin.whattoplaytoday.common.Resource
import com.vchepyolkin.whattoplaytoday.domain.models.ApiRequest
import com.vchepyolkin.whattoplaytoday.domain.models.Game
import com.vchepyolkin.whattoplaytoday.domain.repository.GameRepository
import kotlinx.coroutines.flow.Flow

class GetGameList(
    private val repository: GameRepository
) {
    suspend operator fun invoke(
        request: ApiRequest
    ) : Flow<Resource<List<Game>>> {
        return repository.getGameList(request)
    }
}