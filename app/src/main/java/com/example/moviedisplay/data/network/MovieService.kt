package com.example.moviedisplay.data.network


import android.util.Log
//import com.example.moviedisplay.data.model.MovieModel
import com.example.moviedisplay.data.model.SearchModel
import com.example.moviedisplay.data.model.detail.DetailModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(private val api:MovieApiClient) {

    suspend fun getPopularMovies(currentPage:Int): SearchModel {
        return withContext(Dispatchers.IO) {
            val response = api.getPopularMovie(currentPage)
            Log.e("ERROR",response.toString())
            Log.e("ERROR",response.toString())
            response?.body() ?: SearchModel()
        }
    }


    suspend fun getDetailMovie(movieId:Int): DetailModel {
        return withContext(Dispatchers.IO) {
            val response = api.getDetailMovie(movieId.toString())
            Log.e("ERROR",response.toString())
            Log.e("ERROR",response.toString())
            response?.body() ?: DetailModel()
        }
    }




/*
    suspend fun getMoviesQuotes(): List<MovieModel> {
        return withContext(Dispatchers.IO) {
            val response = api.getAllmovies()
            Log.e("ERROR",response.toString())
            Log.e("ERROR",response.body().toString())
            response.body() ?: emptyList()
        }
    }
*/

}