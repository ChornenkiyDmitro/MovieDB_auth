package com.example.movie.data_source.database.entity.databaseconvertor

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "users")
data class UserEntity(


    @PrimaryKey(autoGenerate = false)
    @SerializedName("name")
    val name: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,



    )