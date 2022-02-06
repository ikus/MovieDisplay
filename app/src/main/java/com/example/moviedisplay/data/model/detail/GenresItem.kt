package com.example.moviedisplay.data.model.detail

import com.google.gson.annotations.SerializedName

data class GenresItem (
    @SerializedName("name")
    val name: String? = null,

    @SerializedName("id")
    val id: Int = 0
)
