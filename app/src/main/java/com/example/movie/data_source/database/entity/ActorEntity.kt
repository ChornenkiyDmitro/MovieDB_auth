package com.example.movie.data_source.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity(tableName = "actor")
data class ActorEntity (

     @PrimaryKey(autoGenerate = false)
     val id:Int?,

     @SerializedName("name")
     val name: String?,

     @SerializedName("biography")
     val biography: String?,

     @SerializedName("profile_path")
     val profile_path:String?,
        )