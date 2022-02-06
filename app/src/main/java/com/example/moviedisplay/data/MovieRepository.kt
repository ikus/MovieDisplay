package com.example.moviedisplay.data

import com.example.moviedisplay.data.database.dao.MovieDao
import com.example.moviedisplay.data.database.entities.MovieEntity
//import com.example.moviedisplay.data.model.MovieModel
import com.example.moviedisplay.data.model.SearchModel
import com.example.moviedisplay.data.network.MovieService
import com.example.moviedisplay.domain.model.ResultItem
//import com.example.moviedisplay.domain.model.Movie
import com.example.moviedisplay.domain.model.Search
import com.example.moviedisplay.domain.model.toDomain
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val api: MovieService,
    private val movieDao: MovieDao
) {

    suspend fun getAllMoviesFromApi(currentpage:Int): Search {
        val response: SearchModel = api.getMovies(currentpage)
        return response.toDomain()
    }



/*
    suspend fun getAllMoviesFromApi(): List<Movie> {
        val response: List<MovieModel> = api.getMoviesQuotes()
        return response.map { it.toDomain() }
    }
*/

    suspend fun getAllMoviesFromDatabase():List<ResultItem>{
        val response: List<MovieEntity> = movieDao.getAllMovies()
        return response.map { it.toDomain() }
    }


/*
    suspend fun getAllMoviesFromDatabase():List<Movie>{
        val response: List<MovieEntity> = movieDao.getAllMovies()
        return response.map { it.toDomain() }
    }
*/

    suspend fun insertMovies(movies:List<MovieEntity>){
        movieDao.insertAll(movies)
    }

    suspend fun clearMovies(){
        movieDao.deleteAllMovies()
    }
}