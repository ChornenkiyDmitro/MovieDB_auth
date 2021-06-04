package com.example.movie.remote_data_source.pojo

import com.example.movie.data_source.database.entity.MovieEntity
import com.google.gson.annotations.SerializedName

data class CastMovieResponse(

@SerializedName("id")
val id: Int,

@SerializedName("cast")
val cast: List<MovieEntity>
)