package com.example.moviedisplay.model

import android.util.Log
import com.example.moviedisplay.data.MovieRepository
import com.example.moviedisplay.data.database.entities.toDatabase
import com.example.moviedisplay.data.model.detail.DetailModel
import com.example.moviedisplay.domain.model.MovieDetail
//import com.example.moviesdb.domain.model.Movie
import com.example.moviedisplay.domain.model.ResultItem
import com.example.moviedisplay.domain.model.toDomain
import javax.inject.Inject

class GetDetailUseCase @Inject constructor(private val repository: MovieRepository) {

    suspend operator fun invoke(movieID:Int): MovieDetail {
        //val search = repository.getDetailMovieFromApi(movieID)
        val detail= repository.getDetailMovieFromApi(movieID)
        Log.d("DETAIIL::", detail.title!!)
        //TODO: Refacorizar la pagina qu devuelve

        if(detail != null){
            Log.i("INFO::","Tenemos detalles" +detail.originalLanguage)
            repository.clearDetails()
            repository.insertDetails(detail.toDatabase())//(movies.map { it.toDatabase() })
            detail
        }else{
            //Obter de la base de datos
        }

        return detail
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