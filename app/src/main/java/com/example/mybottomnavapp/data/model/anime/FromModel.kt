package com.example.mybottomnavapp.data.model.anime


import com.google.gson.annotations.SerializedName

data class FromModel(
    @SerializedName("day")
    val day: Int? = 0,
    @SerializedName("month")
    val month: Int? = 0,
    @SerializedName("year")
    val year: Int? = 0
)