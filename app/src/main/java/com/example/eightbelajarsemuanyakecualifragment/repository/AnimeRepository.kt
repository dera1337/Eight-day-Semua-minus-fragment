package com.example.eightbelajarsemuanyakecualifragment.repository

import com.example.eightbelajarsemuanyakecualifragment.model.RecentAnimeResponse
import com.example.eightbelajarsemuanyakecualifragment.utils.Resource
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeRepository {

    suspend fun getRecentAnimeList(
        page: Int
    ): Resource<List<RecentAnimeResponse>>
}