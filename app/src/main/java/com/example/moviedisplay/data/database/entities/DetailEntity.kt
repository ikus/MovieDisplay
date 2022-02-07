package com.example.moviedisplay.data.database.entities



import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
//import com.example.moviedisplay.domain.model.Movie
import com.example.moviedisplay.domain.model.MovieDetail

@Entity(tableName = "detail_table")
data class DetailEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "id") val id: Int? = 0,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "originalLanguage") val originalLanguage: String?,



    //@ColumnInfo(name = "movie") val movie: String?,
    //@ColumnInfo(name = "favorite") val favorite: Boolean,
    //@ColumnInfo(name = "quote") val quote: String,
    //@ColumnInfo(name = "author") val author: String
)

//fun Movie.toDatabase() = MovieEntity(id = id,title=title)
fun MovieDetail.toDatabase() = DetailEntity(id = id,title=title,originalLanguage=originalLanguage)
//fun Movie.toDatabase() = MovieEntity(id = id,title=title, movie = movie, favorite=favorite,quote=quote, author =  author)