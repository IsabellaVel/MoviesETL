package com.isabellavel.edenmovies.ui.main.view

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.isabellavel.edenmovies.R
import com.isabellavel.edenmovies.data.api.ApiHelper
import com.isabellavel.edenmovies.data.api.ApiServiceImplementation
import com.isabellavel.edenmovies.data.model.Movie
import com.isabellavel.edenmovies.ui.base.ViewModelFactory
import com.isabellavel.edenmovies.ui.main.adapter.MainAdapter
import com.isabellavel.edenmovies.ui.main.viewmodel.MainViewModel
import com.isabellavel.edenmovies.utils.Status

class MainActivity: AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupViewModel()
        setupObserver()
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProviders.of(
            this,
        ViewModelFactory(ApiHelper(ApiServiceImplementation()))
        )
        .get(MainViewModel::class.java)
    }

    private fun setupObserver() {
        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        mainViewModel.getMovies().observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    progressBar.visibility = View.GONE
                    it.data?.let { movies -> updateAdapter(movies)}
                    recyclerView.visibility = View.VISIBLE
                }
                Status.LOADING -> {
                    progressBar.visibility = View.VISIBLE
                    recyclerView.visibility = View.GONE
                }
                Status.ERROR -> {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun updateAdapter(movies: List<Movie>) {
        adapter.addData(movies)
        adapter.notifyDataSetChanged()
    }

    private fun setupUI() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }
}