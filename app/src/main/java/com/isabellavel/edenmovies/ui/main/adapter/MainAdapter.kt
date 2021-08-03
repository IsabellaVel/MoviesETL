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
import com.isabellavel.edenmovies.ui.main.adapter.MainAdapter.*


class MainAdapter(
    private val movies: ArrayList<Movie>,
    private val listener: (Movie) -> Unit
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = DataViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_layout, parent,
            false
        )
    )

    override fun getItemCount(): Int = movies.size
    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val item = movies[position]
        holder.bind(item)
        holder.itemView.setOnClickListener { listener(item)}
    }

    fun addData(list: List<Movie>) {
        movies.addAll(list)
    }
}


/**private class MyAdapter(private val mDataset: Array<String>) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view),
        View.OnClickListener {
        private var mItem: String? = null
        private val mTextView: TextView
        fun setItem(item: String?) {
            mItem = item
            mTextView.text = item
        }

        override fun onClick(view: View) {
            Log.d(TAG, "onClick $position $mItem")
        }

        init {
            view.setOnClickListener(this)
            mTextView = view as TextView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setItem(mDataset[position])
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }
}
**/


