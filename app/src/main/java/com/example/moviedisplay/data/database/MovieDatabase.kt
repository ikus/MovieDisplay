package com.example.moviedisplay.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.moviedisplay.data.database.dao.MovieDao
import com.example.moviedisplay.data.database.entities.DetailEntity
import com.example.moviedisplay.data.database.entities.MovieEntity

@Database(entities = [MovieEntity::class,DetailEntity::class], version = 1)
abstract class MovieDatabase: RoomDatabase() {

    abstract fun getMovieDao():MovieDao
}
