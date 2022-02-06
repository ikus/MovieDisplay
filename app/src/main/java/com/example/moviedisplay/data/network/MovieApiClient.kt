package com.example.moviedisplay.data.network

//import com.example.moviedisplay.data.model.MovieModel
import com.example.moviedisplay.data.model.SearchModel
import com.example.moviedisplay.data.model.detail.DetailModel
import com.example.moviedisplay.data.model.upcomig.UpcomingModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Path


interface MovieApiClient {

    @GET("movie/popular?")
    suspend fun getPopularMovie(@Query("page") page: Int): Response<SearchModel?>?

    @GET("search/movie")
    suspend fun getSearchMovie(
        @Query("page") page: Int,
        @Query("query") query: String?
    ): Call<SearchModel?>?

    @GET("movie/{movie_id}")
    suspend fun getDetailMovie(@Path("movie_id") movie_id: String?): Response<DetailModel?>?


    @GET("movie/upcoming")
    suspend fun getUpcomingMovie(): Response<UpcomingModel?>?



    //@GET("/.json")
    //suspend fun getAllmovies(): Response<List<MovieModel>>
}