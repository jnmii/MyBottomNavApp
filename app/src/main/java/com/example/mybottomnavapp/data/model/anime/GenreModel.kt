package com.example.mybottomnavapp.data.model.anime


import com.google.gson.annotations.SerializedName

data class GenreModel(
    @SerializedName("mal_id")
    val malId: Int? = 0,
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("url")
    val url: String? = ""
)