package com.isabellavel.edenmovies.data.api

class ApiHelper(private val apiService: MovieService) {
    fun getMovies() = apiService.getMovies()
}