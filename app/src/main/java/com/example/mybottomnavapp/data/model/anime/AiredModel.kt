package com.example.mybottomnavapp.data.model.anime


import com.google.gson.annotations.SerializedName

data class AiredModel(
    @SerializedName("from")
    val from: String? = "",
    @SerializedName("prop")
    val prop: PropModel? = PropModel(),
    @SerializedName("to")
    val to: String? = ""
)