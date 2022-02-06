package com.example.moviedisplay.data.model

import com.google.gson.annotations.SerializedName

data class ResultsItem (
    @SerializedName("overview")
    val overview: String? = null,

    @SerializedName("original_language")
    val originalLanguage: String? = null,

    @SerializedName("original_title")
    val originalTitle: String? = null,

    @SerializedName("video")
    val isVideo: Boolean = false,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("genre_ids")
    val genreIds: List<Int>? = null,

    @SerializedName("poster_path")
    val posterPath: String? = null,

    @SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @SerializedName("release_date")
    val releaseDate: String? = null,

    @SerializedName("vote_average")
    val voteAverage: Double = 0.0,

    @SerializedName("popularity")
    val popularity: Double = 0.0,

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("adult")
    val isAdult: Boolean = false,

    @SerializedName("vote_count")
    val voteCount: Int = 0
)