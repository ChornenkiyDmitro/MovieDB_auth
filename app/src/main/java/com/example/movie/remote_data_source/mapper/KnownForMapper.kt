package com.example.movie.remote_data_source.mapper

import com.example.movie.data_source.database.entity.MovieEntity
import com.example.movie.remote_data_source.pojo.KnownForResponse

fun List<KnownForResponse>.mapToMovies(): List<MovieEntity> {
    val movies = arrayListOf<MovieEntity>()
    forEach {
        movies.addAll(it.knowFor)
    }
    return movies
}