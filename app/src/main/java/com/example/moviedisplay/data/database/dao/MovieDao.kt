package com.example.moviedisplay.data.database.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviedisplay.data.database.entities.DetailEntity
import com.example.moviedisplay.data.database.entities.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table") //" ORDER BY author DESC")
    suspend fun getAllMovies():List<MovieEntity>


    @Query("SELECT * FROM movie_table WHERE id = :movieId") //" ORDER BY author DESC")
    suspend fun getMovie(movieId:Int):MovieEntity

    @Query("UPDATE movie_table SET favorite = :isFavorite WHERE id = :movieId") //" ORDER BY author DESC")
    suspend fun setFavoriteMovie(movieId:Int,isFavorite:Int):Unit

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies:List<MovieEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDetail(detail: DetailEntity)

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllMovies()
}