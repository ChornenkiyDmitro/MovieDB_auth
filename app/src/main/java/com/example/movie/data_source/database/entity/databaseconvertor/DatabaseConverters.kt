package com.example.movie.data_source.database.entity.databaseconvertor

import androidx.room.TypeConverter
import com.example.movie.data_source.database.entity.GenreEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


class DatabaseConverters {

    @TypeConverter
    fun genresToJson(list : List<GenreEntity>?): String =
        list?.takeIf { it.isNotEmpty() }?.let { genres ->
             Gson().toJson(genres, object : TypeToken<List<GenreEntity>>() {}.type)
        } ?: ""

    @TypeConverter
    fun jsonToGenres(json: String): List<GenreEntity> = if (json.isNotEmpty()) {
        Gson().fromJson(json, object : TypeToken<List<GenreEntity>>() {}.type)
    } else listOf()

 }
