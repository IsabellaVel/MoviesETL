package com.isabellavel.edenmovies.data.repository

import com.isabellavel.edenmovies.data.api.ApiHelper
import com.isabellavel.edenmovies.data.api.MovieService
import com.isabellavel.edenmovies.data.model.Movie
import retrofit2.Call
import io.reactivex.Single

class MainRepository (private val apiHelper: ApiHelper){
    fun getMovies(): Single<List<Movie>> {
        return apiHelper.getMovies()
    }
}