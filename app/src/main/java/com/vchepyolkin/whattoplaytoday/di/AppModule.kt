package com.vchepyolkin.whattoplaytoday.di

import android.app.Application
import androidx.room.Room
import com.vchepyolkin.whattoplaytoday.common.Constants
import com.vchepyolkin.whattoplaytoday.data.local.GameDao
import com.vchepyolkin.whattoplaytoday.data.local.GameDatabase
import com.vchepyolkin.whattoplaytoday.data.remote.TwitchApi
import com.vchepyolkin.whattoplaytoday.data.repository.GameRepositoryImpl
import com.vchepyolkin.whattoplaytoday.data.repository.OAuthRepositoryImpl
import com.vchepyolkin.whattoplaytoday.domain.repository.GameRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTwitchApi(): TwitchApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_GAME_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TwitchApi::class.java)
    }

    @Provides
    @Singleton
    fun provideGameRepository(api: TwitchApi, db: GameDatabase): GameRepository {
        return GameRepositoryImpl(api, db.dao)
    }

    @Provides
    @Singleton
    fun provideOAuthRepository(
        api: TwitchApi,
        app: Application
    ): OAuthRepositoryImpl {
        return OAuthRepositoryImpl(api, app)
    }

    @Provides
    @Singleton
    fun provideGameDatabase(app: Application): GameDatabase {
        return Room.databaseBuilder(
            app,
            GameDatabase::class.java,
            "game_db",
        ).build()
    }
}