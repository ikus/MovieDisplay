package com.example.moviedisplay.data

import android.util.Log
import com.example.moviedisplay.data.database.dao.MovieDao
import com.example.moviedisplay.data.database.entities.DetailEntity
import com.example.moviedisplay.data.database.entities.MovieEntity
//import com.example.moviedisplay.data.model.MovieModel
import com.example.moviedisplay.data.model.SearchModel
import com.example.moviedisplay.data.model.detail.DetailModel
import com.example.moviedisplay.data.network.MovieService
import com.example.moviedisplay.domain.model.MovieDetail
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
        val response: SearchModel = api.getPopularMovies(currentpage)
        return response.toDomain()
    }

    suspend fun getDetailMovieFromApi(movieId:Int): MovieDetail {
        val response :DetailModel = api.getDetailMovie(movieId)
        Log.d("DETALLE::", response.overview!!)
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

    suspend fun insertDetails(movies:DetailEntity){
        //movieDao.insertAll(movies)
    }

    suspend fun clearMovies(){
        movieDao.deleteAllMovies()
    }

    suspend fun clearDetails(){
        //movieDao.deleteAllMovies()
    }

}