package com.isabellavel.edenmovies.data.api

import com.isabellavel.edenmovies.data.model.Movie
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface MovieService {
    @Headers("User-Agent: EdenMovies",
        "Cache-Control: max-age=640000")
    @GET("movies-coming-soon.json")
    fun getMovies(): Single<List<Movie>>
}