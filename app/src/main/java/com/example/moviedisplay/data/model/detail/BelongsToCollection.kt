package com.example.moviedisplay.data.model.detail

import com.google.gson.annotations.SerializedName

data class BelongsToCollection (
    @SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("poster_path")
    val posterPath: String? = null
)
