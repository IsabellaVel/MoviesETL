package com.isabellavel.edenmovies.ui.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.isabellavel.edenmovies.data.api.ApiHelper
import com.isabellavel.edenmovies.data.repository.MainRepository
import com.isabellavel.edenmovies.ui.main.viewmodel.MainViewModel

class ViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
       if (modelClass.isAssignableFrom(MainViewModel::class.java)){
           return MainViewModel(MainRepository(apiHelper)) as T
       }
        throw IllegalArgumentException("Unknown class name")
    }

}