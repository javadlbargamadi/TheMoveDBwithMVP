package com.example.themovedbwithmvp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.themovedbwithmvp.MovieListClass.Result
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item.view.*

class TMDbRecyclerAdapter(private val resultList: List<Result>) :
    RecyclerView.Adapter<TMDbRecyclerAdapter.TMDbRecyclerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TMDbRecyclerViewHolder {
        return TMDbRecyclerViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.recycler_item,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = resultList.size

    override fun onBindViewHolder(holder: TMDbRecyclerViewHolder, position: Int) = holder.onBind(
        resultList[position].title,
        resultList[position].overview,
        resultList[position].posterPath
    )

    class TMDbRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun onBind(title: String, overview: String, posterPath: String) {
            val posterBaseUrl = "https://image.tmdb.org/t/p/w500"
            Picasso.get().load(posterBaseUrl + posterPath).into(itemView.imgPoster)
            itemView.txtMovieTitle.text = title
            itemView.txtOverView.text = overview
        }
    }
}