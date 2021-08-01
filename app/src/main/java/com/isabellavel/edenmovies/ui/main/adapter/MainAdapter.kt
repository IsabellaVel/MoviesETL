package com.isabellavel.edenmovies.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.isabellavel.edenmovies.R
import com.isabellavel.edenmovies.data.model.Movie

class MainAdapter(
    private val movies: ArrayList<Movie>
) : RecyclerView.Adapter<MainAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(movie: Movie) {
            itemView.findViewById<TextView>(R.id.tvTitle).text = movie.title
            itemView.findViewById<TextView>(R.id.year).text = movie.year
            Glide.with(itemView.findViewById<ImageView>(R.id.poster).context)
                .load(movie.posterurl)
                .into(itemView.findViewById<ImageView>(R.id.poster))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder (
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout, parent,
            false
        )
    )

    override fun getItemCount(): Int = movies.size
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(movies[position])

    fun addData(list: List<Movie>) {
        movies.addAll(list)
    }
}