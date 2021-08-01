package com.isabellavel.edenmovies.data.api

import com.isabellavel.edenmovies.data.model.Movie
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {

    @GET("movies-coming-soon.json")
    fun getMovies(): Single<List<Movie>>
}