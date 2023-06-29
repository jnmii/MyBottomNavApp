package com.example.mybottomnavapp.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiDetails {
    //anime
    const val BASE_URL = "https://api.jikan.moe/v4/"
    const val END_POINT = "random/anime"
    //Rick n Morty
    const val  RICK_URL = "https://rickandmortyapi.com/api/"
    const val  RICK_END_POINT = "character/{id}"

    val okhttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()
    val retrofitInstance = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttpClient)
        .build()
    val retrofitRick = Retrofit.Builder()
        .baseUrl(RICK_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttpClient)
        .build()

    val apiClient = retrofitInstance.create(ApiCall::class.java)
    val rickClient = retrofitRick.create(ApiCall::class.java)

}