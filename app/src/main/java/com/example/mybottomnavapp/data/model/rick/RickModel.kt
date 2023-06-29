package com.example.mybottomnavapp.data.model.rick



import com.google.gson.annotations.SerializedName

class RickModel {
    @SerializedName("name")
    val name: String? = ""

    @SerializedName("image")
    val image: String? = ""

    @SerializedName("episode")
    private val episodeUrls: List<String>? = null

    val episode: List<String>
        get() {
            return episodeUrls ?: emptyList()
        }
}