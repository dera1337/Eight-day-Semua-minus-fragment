package com.example.eightbelajarsemuanyakecualifragment.api

import com.example.eightbelajarsemuanyakecualifragment.model.RecentAnimeResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface AnimeAPI {

    @GET("recent/{page}")
    suspend fun getRecentAnimeList(
        @Path("page") page: Int
    ): Response<List<RecentAnimeResponse>>


}