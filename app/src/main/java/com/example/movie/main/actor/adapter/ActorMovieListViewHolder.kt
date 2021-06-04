package com.example.movie.main.actor.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie.data_source.database.entity.MovieEntity
import kotlinx.android.synthetic.main.item_movie.view.*

class ActorMovieListViewHolder
    (itemView: View,
     ): RecyclerView.ViewHolder(itemView) {

    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
    fun bind(movie: MovieEntity){
        itemView.textMovieTitle.text = movie.title
        Glide.with(itemView)
            .load(IMAGE_BASE + movie.posterPath)
            .into(itemView.imageMoviePoster)

    }
}