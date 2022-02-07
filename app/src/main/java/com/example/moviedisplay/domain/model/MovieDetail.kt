package com.example.moviedisplay.domain.model

import com.example.moviedisplay.data.model.SearchModel
import com.example.moviedisplay.data.model.detail.DetailModel

//import com.example.moviedisplay.data.model.detail.*
//import com.google.gson.annotations.SerializedName


data class MovieDetail (val id:Int?,val title:String?,val originalLanguage:String?,
                        val posterPath:String?,
                        val backdropPath:String?,
                        val revenue:Int?,
                        val popularity:Double?,
                        val voteCount:Int?,
                        val budget:Int?,
                        val overview:String?,
                        val originalTitle:String?,
                        val releaseDate:String?,
                        val voteAverage:Double?,
                        val isAdult:Boolean?,
                        val homepage:String?,
                        val status:String?
                        )

fun DetailModel.toDomain() = MovieDetail(id,title,originalLanguage,
    posterPath,
  backdropPath ,
  revenue,
  popularity,
  voteCount,
  budget,
  overview ,
  originalTitle ,
  releaseDate ,
  voteAverage,
  isAdult,
  homepage ,
  status
)

/*
data class DetailModel (
    @SerializedName("original_language")
    val originalLanguage: String? = null,

    @SerializedName("imdb_id")
    val imdbId: String? = null,

    @SerializedName("video")
    val isVideo: Boolean = false,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("backdrop_path")
    val backdropPath: String? = null,

    @SerializedName("revenue")
    val revenue: Int = 0,

    @SerializedName("genres")
    val genres: List<GenresItem>? = null,

    @SerializedName("popularity")
    val popularity: Double = 0.0,

    @SerializedName("production_countries")
    val productionCountries: List<ProductionCountriesItem>? = null,

    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("vote_count")
    val voteCount: Int = 0,

    @SerializedName("budget")
    val budget: Int = 0,

    @SerializedName("overview")
    val overview: String? = null,

    @SerializedName("original_title")
    val originalTitle: String? = null,

    @SerializedName("runtime")
    val runtime: Int = 0,

    @SerializedName("poster_path")
    val posterPath: String? = null,

    @SerializedName("spoken_languages")
    val spokenLanguages: List<SpokenLanguagesItem>? = null,

    @SerializedName("production_companies")
    val productionCompanies: List<ProductionCompaniesItem>? = null,

    @SerializedName("release_date")
    val releaseDate: String? = null,

    @SerializedName("vote_average")
    val voteAverage: Double = 0.0,

    @SerializedName("belongs_to_collection")
    val belongsToCollection: BelongsToCollection? = null,

    @SerializedName("tagline")
    val tagline: String? = null,

    @SerializedName("adult")
    val isAdult: Boolean = false,

    @SerializedName("homepage")
    val homepage: String? = null,

    @SerializedName("status")
    val status: String? = null
)
*/