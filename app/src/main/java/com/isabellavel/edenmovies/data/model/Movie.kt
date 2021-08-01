package com.isabellavel.edenmovies.data.model

import com.google.gson.annotations.SerializedName

data class Movie(
    @SerializedName("title")
    val title: String = "",
    @SerializedName("poster")
    val poster: String = "",
    @SerializedName("storyline")
    val storyline: String = "",
    @SerializedName("actors")
    val actors: List<String> = arrayListOf(),
    @SerializedName("posterurl")
    val posterurl: String = "",
    @SerializedName("year")
    val year: String = ""
    )
