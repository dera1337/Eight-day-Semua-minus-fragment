package com.example.eightbelajarsemuanyakecualifragment.dependency_injection

import com.example.eightbelajarsemuanyakecualifragment.api.AnimeAPI
import com.example.eightbelajarsemuanyakecualifragment.repository.AnimeReopositoryImpl
import com.example.eightbelajarsemuanyakecualifragment.repository.AnimeRepository
import com.example.eightbelajarsemuanyakecualifragment.utils.Constants.BASE_URL
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
    fun provideAnimeAPI(): AnimeAPI {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AnimeAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideAnimeRepository(
        api: AnimeAPI
    ): AnimeRepository{
        return AnimeReopositoryImpl(api)
    }
}