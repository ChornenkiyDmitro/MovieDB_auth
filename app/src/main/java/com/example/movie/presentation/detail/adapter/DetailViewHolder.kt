package com.example.movie.presentation.detail.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movie.data_source.database.entity.ActorEntity
import com.example.movie.data_source.database.entity.MovieEntity
import com.example.movie.main.MainActivity
import com.example.movie.presentation.detail.DetailActivity
import kotlinx.android.synthetic.main.item_actor.view.*
import kotlinx.android.synthetic.main.item_movie.view.*

class DetailViewHolder(


        itemView: View,
         private val listener: DetailActivity
) : RecyclerView.ViewHolder(itemView) {

    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
    fun bind(actor: ActorEntity) {
        itemView.textActorName.text = actor.name
        Glide.with(itemView)
                .load(IMAGE_BASE + actor.profile_path)
                .into(itemView.imageActorPhoto)

         itemView.setOnClickListener {
            listener.onClickActor(actor)
         }
    }
}