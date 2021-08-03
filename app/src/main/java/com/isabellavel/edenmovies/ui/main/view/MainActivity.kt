package com.isabellavel.edenmovies.ui.main.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ListView
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
import com.isabellavel.edenmovies.ui.main.adapter.MovieAdapter
import com.isabellavel.edenmovies.ui.main.viewmodel.MainViewModel
import com.isabellavel.edenmovies.utils.Status

class MainActivity: AppCompatActivity() {
    private lateinit var mainViewModel: MainViewModel
    private lateinit var adapter: MainAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar
    val MOVIE_ID = "movie id"

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
        adapter = MainAdapter(arrayListOf()) { item ->
            adapterOnClick(item)
        }
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter

    }

    private fun adapterOnClick(movie: Movie) {
        val intent = Intent(this, MovieDetailActivity::class.java)
        //intent.putExtra(MOVIE_ID, movie)
        intent.putExtra(MOVIE_ID, movie.title)
        intent.putExtra(getString(R.string.story), movie.storyline)
        intent.putExtra(getString(R.string.actors), movie.actors.joinToString { it })
        intent.putExtra(getString(R.string.genre), movie.genres.joinToString { it })
        val av = movie.ratings.sum()/movie.ratings.count()
        intent.putExtra(getString(R.string.ratings), movie.ratings.joinToString {it.toString()})
        intent.putExtra(getString(R.string.url), movie.posterurl)
        intent.putExtra(getString(R.string.content), movie.contentR)
        intent.putExtra(getString(R.string.year), movie.year)
        intent.putExtra(getString(R.string.id), movie.id)
        intent.putExtra(getString(R.string.imdb), movie.imdbRating)
        intent.putExtra(getString(R.string.duration), movie.duration)
        intent.putExtra(getString(R.string.release), movie.relDate )
        intent.putExtra(getString(R.string.average), movie.avRating.toString())
        intent.putExtra(getString(R.string.original), movie.originalTitle)

        startActivity(intent)
    }
}