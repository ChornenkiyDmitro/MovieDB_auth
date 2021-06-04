package com.example.movie.main.adapter

import com.example.movie.data_source.database.entity.MovieEntity

interface ItemMovieListener {
    fun onClickMovie(movie: MovieEntity)
}