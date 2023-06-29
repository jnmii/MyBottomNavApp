package com.example.mybottomnavapp.data.remote

import com.example.mybottomnavapp.data.model.anime.AnimeModel
import com.example.mybottomnavapp.data.model.rick.RickModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiCall {

    @GET(ApiDetails.END_POINT)
    suspend fun getRandomAnime(): AnimeModel

    @GET(ApiDetails.RICK_END_POINT)
    suspend fun getRickCharacter(@Path("id") id: Int): RickModel

}