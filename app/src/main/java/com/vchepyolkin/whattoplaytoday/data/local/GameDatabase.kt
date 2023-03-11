package com.vchepyolkin.whattoplaytoday.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vchepyolkin.whattoplaytoday.data.local.entity.GameEntity

@Database(
    entities = [GameEntity::class],
    version = 1,
)
abstract class GameDatabase : RoomDatabase() {

    abstract val dao: GameDao
}