package com.vchepyolkin.whattoplaytoday.data.repository

import com.vchepyolkin.whattoplaytoday.common.Resource
import com.vchepyolkin.whattoplaytoday.data.local.GameDao
import com.vchepyolkin.whattoplaytoday.data.local.entity.FavoriteGameEntity
import com.vchepyolkin.whattoplaytoday.data.remote.TwitchApi
import com.vchepyolkin.whattoplaytoday.domain.models.ApiRequest
import com.vchepyolkin.whattoplaytoday.domain.models.Game
import com.vchepyolkin.whattoplaytoday.domain.repository.GameRepository
import com.vchepyolkin.whattoplaytoday.domain.utils.RequestType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okio.IOException
import retrofit2.HttpException

class GameRepositoryImpl(
    private val api: TwitchApi,
    private val dao: GameDao,
) : GameRepository {

    override suspend fun getGameList(
        request: ApiRequest,
    ): Flow<Resource<List<Game>>> = flow {
        emit(Resource.Loading())

        val games = dao.getGames().map { it.toGame() }
        emit(Resource.Loading(data = games))

        try {
            val remoteGames = api.getGameList(
                request.clientId,
                request.token,
                "fields name, cover.url, age_ratings.rating, genres.name, alternative_names.name, follows, rating, summary, artworks.url, videos.video_id, platforms.category, websites.url;\n" +
                        "where follows != null & cover.url != null;\n" +
                        "sort follows desc;\n" +
                        "limit 100;"
            )
            dao.deleteGames(games.map { it.name })
            dao.insertGames(remoteGames.map { it.toGameEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = "Oops, something went wrong!",
                data = games
            ))
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection.",
                    data = games
                )
            )
        }

        val newGames = dao.getGames().map { it.toGame() }
        emit(Resource.Success(newGames))
    }

    override suspend fun getGameListByName(
        request: ApiRequest,
    ): Flow<Resource<List<Game>>> = flow {
        emit(Resource.Loading())

        val games = dao.getGames().map { it.toGame() }
        emit(Resource.Loading(data = games))

        try {
            val remoteGames = api.getGameList(
                clientId = request.clientId,
                accessToken = request.token,
                "fields name, cover.url, age_ratings.rating, genres.name, follows, rating, summary, artworks.url, videos.video_id;\n" +
                        "search \"${request.gameName}\" & age_rating.rating <= ${request.ageRating};\n" +
                        "where follows != null & cover.url != null;\n" +
                        "limit 100;"
            )
            dao.deleteGames(games.map { it.name })
            dao.insertGames(remoteGames.map { it.toGameEntity() })
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Oops, something went wrong!",
                    data = games
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "Couldn't reach server, check your internet connection.",
                    data = games
                )
            )
        }
    }

    override suspend fun getFavoriteGames(): Flow<List<FavoriteGameEntity>> {
        TODO("Not yet implemented")
    }
}

