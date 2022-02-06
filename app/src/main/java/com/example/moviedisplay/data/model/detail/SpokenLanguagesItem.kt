package com.example.moviedisplay.data.model.detail

import com.google.gson.annotations.SerializedName

data class SpokenLanguagesItem (
    @SerializedName("name")
    val name: String? = null,

    @SerializedName("iso_639_1")
    val iso6391: String? = null
)