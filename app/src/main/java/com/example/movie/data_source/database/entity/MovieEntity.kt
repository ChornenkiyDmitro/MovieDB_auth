package com.example.movie.data_source.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "movie")
data class MovieEntity (

    @PrimaryKey (autoGenerate = false)
    val id: Int?,

    @SerializedName("title")
    val title:String?,

    @SerializedName("vote_average")
    val voteAverage :String?,

    @SerializedName("poster_path")
    val posterPath:String?,

    @SerializedName("genres")
    val overview: List<GenreEntity>
        )
