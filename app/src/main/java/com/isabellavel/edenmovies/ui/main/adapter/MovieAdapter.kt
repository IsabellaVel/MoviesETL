package com.isabellavel.edenmovies.ui.main.adapter

import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.isabellavel.edenmovies.R
import com.isabellavel.edenmovies.data.model.Movie

class MovieAdapter(
    private val context: Context,
    private val movies: ArrayList<Movie>
) : BaseAdapter() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return movies.size
    }

    override fun getItem(p0: Int): Any {
        return movies[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.item_layout, p2, false)
        val movie = getItem(p0) as Movie
        val titletv = rowView.findViewById<TextView>(R.id.tvTitle)
        val yeartv = rowView.findViewById<TextView>(R.id.year)

        titletv.text = movie.title
        yeartv.text = movie.year
        Glide.with(rowView.findViewById<ImageView>(R.id.poster).context)
            .load(movie.posterurl)
            .into(rowView.findViewById<ImageView>(R.id.poster))

        return rowView
    }
}
