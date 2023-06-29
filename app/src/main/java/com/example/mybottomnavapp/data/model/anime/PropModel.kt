package com.example.mybottomnavapp.data.model.anime


import com.google.gson.annotations.SerializedName

data class PropModel(
    @SerializedName("from")
    val from: FromModel? = FromModel(),
    @SerializedName("string")
    val string: String? = "",
    @SerializedName("to")
    val to: ToModel? = ToModel()
)