package com.isabellavel.edenmovies.ui.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.isabellavel.edenmovies.data.model.Movie
import com.isabellavel.edenmovies.data.repository.MainRepository
import com.isabellavel.edenmovies.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(private val mainRepo: MainRepository) : ViewModel() {
    private val movies = MutableLiveData<Resource<List<Movie>>>()
    private val compositeDisposable = CompositeDisposable()
    init {
        fetchMovies()
    }
    private fun fetchMovies() {
        movies.postValue(Resource.loading(null))
        compositeDisposable.add(
                mainRepo.getMovies()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ movieList ->
                            movies.postValue(Resource.success(movieList))
                        }, {throwable ->
                            movies.postValue(Resource.error(
                                    "Something went wrong", null
                            ))
                        })

        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    fun getMovies(): LiveData<Resource<List<Movie>>> {
        return movies
    }
}