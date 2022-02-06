package com.example.moviedisplay.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//import com.example.moviedisplay.domain.model.Movie
import com.example.moviedisplay.domain.model.ResultItem

@Entity(tableName = "movie_table")
data class MovieEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int? = 0,
    @ColumnInfo(name = "title") val title: String?,


    //@ColumnInfo(name = "movie") val movie: String?,
    //@ColumnInfo(name = "favorite") val favorite: Boolean,
    //@ColumnInfo(name = "quote") val quote: String,
    //@ColumnInfo(name = "author") val author: String
)

//fun Movie.toDatabase() = MovieEntity(id = id,title=title)
fun ResultItem.toDatabase() = MovieEntity(id = id,title=title)
//fun Movie.toDatabase() = MovieEntity(id = id,title=title, movie = movie, favorite=favorite,quote=quote, author =  author)