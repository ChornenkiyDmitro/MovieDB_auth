package com.example.movie.main.actor.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.data_source.database.entity.MovieEntity

class RecyclerActorMovieList: RecyclerView.Adapter<ActorMovieListViewHolder>() {

    private var movielist = mutableListOf<MovieEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorMovieListViewHolder {
        return ActorMovieListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        )
    }

    override fun getItemCount(): Int = movielist.size

    override fun onBindViewHolder(holder: ActorMovieListViewHolder, position: Int) {
        holder.bind(movielist[position])
    }

    fun setData(movie: List<MovieEntity>) {
        movielist.clear()
        movielist.addAll(movie)
        notifyDataSetChanged()
    }
}