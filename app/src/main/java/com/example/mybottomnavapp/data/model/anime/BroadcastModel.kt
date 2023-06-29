package com.example.mybottomnavapp.data.model.anime


import com.google.gson.annotations.SerializedName

data class BroadcastModel(
    @SerializedName("day")
    val day: String? = "",
    @SerializedName("string")
    val string: String? = "",
    @SerializedName("time")
    val time: String? = "",
    @SerializedName("timezone")
    val timezone: String? = ""
)