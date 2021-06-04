package com.example.movie.data_source.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.movie.data_source.database.dao.MovieDao
import com.example.movie.data_source.database.entity.ActorEntity
import com.example.movie.data_source.database.entity.GenreEntity

import com.example.movie.data_source.database.entity.MovieEntity
import com.example.movie.data_source.database.entity.databaseconvertor.DatabaseConverters

@Database(entities = [MovieEntity::class, ActorEntity::class, GenreEntity::class],version = 1)
@TypeConverters(DatabaseConverters::class)
abstract class MovieDataBase  : RoomDatabase(){
    abstract fun MovieDao():MovieDao
}
