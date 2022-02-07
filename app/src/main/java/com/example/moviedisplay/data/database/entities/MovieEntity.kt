package com.example.moviedisplay.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//import com.example.moviedisplay.domain.model.Movie
import com.example.moviedisplay.data.model.ResultsItem

@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int? = 0,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "favorite") val isFavorite: Boolean,

    //@ColumnInfo(name = "movie") val movie: String?,
    //@ColumnInfo(name = "favorite") val favorite: Boolean,
    //@ColumnInfo(name = "quote") val quote: String,
    //@ColumnInfo(name = "author") val author: String

    @ColumnInfo(name = "adult") val isAdult: Boolean,
    @ColumnInfo(name = "backdrop_path") val backdropPath:String?,
    @ColumnInfo(name = "original_language") val originalLanguage:String?,
    @ColumnInfo(name = "original_title") val originalTitle:String?,
    @ColumnInfo(name = "overview") val overview:String?,
    @ColumnInfo(name = "popularity") val popularity:Double,
    @ColumnInfo(name = "poster_path") val posterPath:String?,
    @ColumnInfo(name = "release_date") val releaseDate:String?,
    @ColumnInfo(name = "video") val isVideo:Boolean,
    @ColumnInfo(name = "vote_average") val voteAverage:Double,
    @ColumnInfo(name = "vote_count") val voteCount:Int

)

fun ResultsItem.toDatabase() = MovieEntity(id = id,title=title,isFavorite=isFavorite,
    isAdult = isAdult,
    backdropPath = backdropPath,
    originalLanguage=originalLanguage,
    originalTitle=originalTitle,
    overview=overview,
    popularity=popularity,
    posterPath=posterPath,
    releaseDate=releaseDate,
    isVideo=isVideo,
    voteAverage=voteAverage,
    voteCount=voteCount
)

//fun Movie.toDatabase() = MovieEntity(id = id,title=title)
//fun ResultItem.toDatabase() = MovieEntity(id = id,title=title, favorite = favorite)
//fun Movie.toDatabase() = MovieEntity(id = id,title=title, movie = movie, favorite=favorite,quote=quote, author =  author)