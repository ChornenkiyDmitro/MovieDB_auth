package com.example.movie.main.adapter

import com.example.movie.data_source.database.entity.GenreEntity


interface GenreListener {
    fun onClickGenre(genre: GenreEntity)
}