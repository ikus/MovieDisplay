package com.example.moviedisplay.di

//import com.omrobbie.cataloguemovie.BuildConfig;

import com.example.moviedisplay.BuildConfig
import com.example.moviedisplay.data.network.MovieApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.HttpUrl
import okhttp3.Request
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit():Retrofit{
        val client = OkHttpClient.Builder()
            .addInterceptor { chain ->
                var original: Request = chain.request()
                val httpUrl: HttpUrl = original.url()
                    .newBuilder()
                    .addQueryParameter("api_key", "28b80b41ebf312e0ba2909f4472d67b6")//BuildConfig.API_KEY)
                    .build()
                original = original.newBuilder()
                    .url(httpUrl)
                    .build()
                chain.proceed(original)
            }
            .build()

        return Retrofit.Builder()
            .client(client)
            //.baseUrl("https://drawsomething-59328-default-rtdb.europe-west1.firebasedatabase.app/")
            // https://api.themoviedb.org/3/discover/movie?api_key=<<api_key>>&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&with_watch_monetization_types=flatrate
            .baseUrl("http://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideMovieApiClient(retrofit: Retrofit):MovieApiClient{
        return retrofit.create(MovieApiClient::class.java)
    }
}