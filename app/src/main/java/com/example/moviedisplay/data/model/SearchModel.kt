package com.example.moviedisplay.data.model

import com.google.gson.annotations.SerializedName
import com.example.moviedisplay.data.model.ResultsItem

data class SearchModel (
    @SerializedName("page")
    val page: Int = 0,

    @SerializedName("total_pages")
    val totalPages: Int = 0,

    @SerializedName("results")
    val results: List<ResultsItem>? = null,

    @SerializedName("total_results")
    val totalResults: Int = 0

)