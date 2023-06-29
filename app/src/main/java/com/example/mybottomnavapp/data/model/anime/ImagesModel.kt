package com.example.mybottomnavapp.data.model.anime


import com.google.gson.annotations.SerializedName

data class ImagesModel(
    @SerializedName("jpg")
    val jpg: JpgModel? = JpgModel(),
    @SerializedName("webp")
    val webp: WebpModel? = WebpModel()
)