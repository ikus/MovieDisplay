package com.example.moviedisplay.data.network


import android.util.Log
//import com.example.moviedisplay.data.model.MovieModel
import com.example.moviedisplay.data.model.SearchModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieService @Inject constructor(private val api:MovieApiClient) {

    suspend fun getMovies(currentPage:Int): SearchModel {
        return withContext(Dispatchers.IO) {
            val response = api.getPopularMovie(currentPage)
            Log.e("ERROR",response.toString())
            Log.e("ERROR",response.toString())
            response?.body() ?: SearchModel()
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