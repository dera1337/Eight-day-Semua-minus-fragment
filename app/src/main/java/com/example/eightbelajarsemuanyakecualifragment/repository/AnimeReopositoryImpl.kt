package com.example.eightbelajarsemuanyakecualifragment.repository

import com.example.eightbelajarsemuanyakecualifragment.api.AnimeAPI
import com.example.eightbelajarsemuanyakecualifragment.model.RecentAnimeResponse
import com.example.eightbelajarsemuanyakecualifragment.utils.Resource
import java.lang.Exception

class AnimeReopositoryImpl(
    private val api: AnimeAPI
) : AnimeRepository {
    override suspend fun getRecentAnimeList(page: Int): Resource<List<RecentAnimeResponse>> {
        return try {
            val response = api.getRecentAnimeList(page)
            val result = response.body()
            if (response.isSuccessful && result != null) {
                Resource.Ok(result, "Success load recent anime list")
            } else {
                Resource.Failed(response.message())
            }
        } catch (e: Exception) {
            Resource.Failed(e.message ?: "No Internet connection")
        }
    }
}