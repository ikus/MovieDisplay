package com.example.moviedisplay.ui

import com.example.moviedisplay.data.database.entities.MovieEntity
import com.example.moviedisplay.data.model.ResultsItem

data class Movie(
    val id: Int,
    //val photo: String?,
    //new fileds
    val adult: Boolean,
    val backdrop_path:String?,
    val original_language:String?,
    val original_title:String?,
    val overview:String?,
    val popularity:Double,
    val poster_path:String?,
    val release_date:String?,
    val title:String?,
    val video:Boolean,
    val vote_average:Double,
    val vote_count:Int
)

fun ResultsItem.toDomain() = Movie(id, isAdult , backdropPath,originalLanguage,originalTitle,overview, popularity,posterPath,releaseDate,title,isVideo, voteAverage,voteCount)
fun MovieEntity.toDomain() = Movie(id!!,isAdult , backdropPath,originalLanguage,originalTitle,overview, popularity,posterPath,releaseDate,title,isVideo, voteAverage,voteCount)
