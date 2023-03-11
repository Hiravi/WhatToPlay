package com.vchepyolkin.whattoplaytoday.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vchepyolkin.whattoplaytoday.data.local.entity.FavoriteGameEntity
import com.vchepyolkin.whattoplaytoday.data.local.entity.GameEntity

@Dao
interface GameDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGames(games: List<GameEntity>)

    @Query("DELETE FROM gameentity WHERE name IN (:games)")
    suspend fun deleteGames(games: List<String>)

    @Query("SELECT * FROM gameentity WHERE name LIKE '%' || :name || '%'")
    suspend fun getGamesByName(name: String) : List<GameEntity>

    @Query("SELECT * FROM gameentity")
    suspend fun getGames() : List<GameEntity>

    @Query("SELECT * FROM favoritegameentity")
    suspend fun getFavoriteGames() : List<FavoriteGameEntity>
}