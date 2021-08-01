package com.isabellavel.edenmovies.data.api

import com.isabellavel.edenmovies.data.model.Movie
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class ApiServiceImplementation: MovieService {
    /**fun getCurrentMovies() {
        val retrofit = Retrofit.Builder()
            .baseUrl(BaseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(MovieService::class.java)
        val call = service.getMovies()
        call.enqueue(object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>, response: Response<List<Movie>>) {
                if (response.code() == 200) {
                   val movieResponse = response.body()!!
                    //add text items
                }
            }
            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                //add errow message
            }
        })
    }
    **/

    override fun getMovies(): Single<List<Movie>> {
        var endpoint = "https://raw.githubusercontent.com/FEND16/movie-json-data/master/json/"

        val retrofit = Retrofit.Builder()
            .baseUrl(endpoint)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        val service = retrofit.create(MovieService::class.java)
        val call = service.getMovies()

        return call
    }
}
