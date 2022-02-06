package com.example.moviedisplay.domain.model



import com.example.moviedisplay.data.database.entities.MovieEntity
import com.example.moviedisplay.data.model.ResultsItem

data class ResultItem (val id:Int?,val title:String?)

//fun ResultsItem.toDomain() = ResultItem(id,title)
fun MovieEntity.toDomain() = ResultItem(id,title)

