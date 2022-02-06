package com.example.moviedisplay.domain.model


//import com.example.moviedisplay.data.database.entities.MovieEntity
import com.example.moviedisplay.data.model.ResultsItem
import com.example.moviedisplay.data.model.SearchModel
import com.google.gson.annotations.SerializedName

data class Search (val page :Int, val totalPages :Int,val results :List<ResultsItem>?, val totalResults:Int)

fun SearchModel.toDomain() = Search(page,totalPages,results, totalResults)
//fun SearchEntity.toDomain() = Movie(movie,favorite,quote, author)
