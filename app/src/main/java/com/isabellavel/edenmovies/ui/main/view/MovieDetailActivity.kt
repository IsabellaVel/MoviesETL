package com.isabellavel.edenmovies.ui.main.view

import android.content.Context
import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.isabellavel.edenmovies.R
import com.isabellavel.edenmovies.data.model.Movie
import org.w3c.dom.Text

class MovieDetailActivity : AppCompatActivity(){
    val TAG = "MovieDetailActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        /**
        val tit: String?, val pos: String?, val story: String?,
        val act: ArrayList<String>?, val url: String?, val yr: String?, val i_d: String?, val genr: ArrayList<String>?,
        val ratg: ArrayList<String>?, val contR: String?, val dur: String?, val relD: String?,val avr: String?,
        val origt: String?, val imdb: String?
         */

        //val movie: Movie? = intent.extras?.getParcelable("movie id")
        val titlei = intent.extras?.getString("movie id")
        val storyi = intent.extras?.getString(getString(R.string.story))
        val actorsi = intent.extras?.getString(getString(R.string.actors))
        val urli = intent.extras?.getString(getString(R.string.url))
        val yeari = intent.extras?.getString(getString(R.string.year))
        val idi = intent.extras?.getString(getString(R.string.id))
        val genrei = intent.extras?.getString(getString(R.string.genre))
        val ratingsi = intent.extras?.getString(getString(R.string.ratings))
        val contentri = intent.extras?.getString(getString(R.string.content))
        val durationi = intent.extras?.getString(getString(R.string.duration))
        val releasei = intent.extras?.getString(getString(R.string.release))
        val avri = intent.extras?.getString(getString(R.string.average))
        val originali = intent.extras?.getString(getString(R.string.original))
        val imdbi = intent.extras?.getString(getString(R.string.imdb))

        findViewById<TextView>(R.id.tvTitle).text = titlei

            findViewById<TextView>(R.id.id).text = idi

            Glide.with(findViewById<ImageView>(R.id.poster).context)
                .load(urli)
                .into(findViewById<ImageView>(R.id.poster))
            findViewById<TextView>(R.id.avRating).text = (avri)
            findViewById<TextView>(R.id.contentRating).text = contentri
            findViewById<TextView>(R.id.duration).text = durationi
            findViewById<TextView>(R.id.genres).text = genrei
            findViewById<TextView>(R.id.imdb).text = imdbi
            findViewById<TextView>(R.id.story).text = storyi
            findViewById<TextView>(R.id.actors).text = actorsi
            findViewById<TextView>(R.id.year).text = yeari
            findViewById<TextView>(R.id.ratings).text = ratingsi
            findViewById<TextView>(R.id.releaseDate).text = releasei
            findViewById<TextView>(R.id.origTitle).text = originali

            }
    }


