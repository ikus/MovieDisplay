package com.example.moviedisplay.model

import android.util.Log
import com.example.moviedisplay.data.MovieRepository
import com.example.moviedisplay.data.database.entities.toDatabase
import com.example.moviedisplay.data.model.ResultsItem
//import com.example.moviesdb.domain.model.Movie
import com.example.moviedisplay.domain.model.ResultItem
import com.example.moviedisplay.domain.model.toDomain
import com.example.moviedisplay.ui.Movie
import com.example.moviedisplay.ui.toDomain
import javax.inject.Inject


class GetMoviesUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(): List<Movie>?{//List<ResultsItem>? {
        //val lista : List<ResultsItem>? = null
        val search = repository.getAllMoviesFromApi(1)

        //val detail= repository.getDetailMovieFromApi(search.results!![0].id)
        //Log.d("DETAIIL::", detail.title!!)
        //TODO: Refacorizar la pagina qu devuelve

        if(search.totalPages<0){
            Log.i("INFO::","Tenemos resultadas" +search.totalResults)
            repository.clearMovies()
            repository.insertMovies(search.results?.map { it.toDatabase() } ?: emptyList())
            search.results
            return   search.results?.map { it.toDomain() }
        }else{
            //Obter de la base de datos
            return repository.getAllMoviesFromDatabase()
        }

       return  search.results?.map { it.toDomain() }
        /*
        return if(search.totalPages>0){
            repository.clearMovies()
            //repository.insertMovies(search.results.map { it.toDatabase() })
        }else{
            repository.getAllMoviesFromDatabase()
        }
*/

        //return emptyList()

    }

    /*
    suspend operator fun invoke():List<Movie>{

        val movies = repository.getAllMoviesFromApi()
        return if(movies.isNotEmpty()){
            repository.clearMovies()
            repository.insertMovies(movies.map { it.toDatabase() })
            movies
        }else{
            repository.getAllMoviesFromDatabase()
        }

        /*val movies = repository.getAllMoviesFromApi()
        return if(movies.isNotEmpty()){
            repository.clearMovies()
            repository.insertMovies(movies.map { it.toDatabase() })
            movies
        }else{
            repository.getAllMoviesFromDatabase()
        }*/
    }
    */

}