package com.example.moviedisplay.data.database.dao


import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.moviedisplay.data.database.entities.MovieEntity

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table") //" ORDER BY author DESC")
    suspend fun getAllMovies():List<MovieEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movies:List<MovieEntity>)

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllMovies()
}