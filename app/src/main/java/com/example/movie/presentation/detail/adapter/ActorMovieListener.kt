package com.example.movie.presentation.detail.adapter

import com.example.movie.data_source.database.entity.ActorEntity


interface ActorMovieListener{
   fun onClickActor(actor: ActorEntity)
}