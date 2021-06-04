package com.example.movie.data_source.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "genre")
data class GenreEntity(

    @PrimaryKey(autoGenerate = false)
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String
    )
