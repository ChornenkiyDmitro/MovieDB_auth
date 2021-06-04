package com.example.movie.main.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.data_source.database.entity.GenreEntity
import com.example.movie.main.MainActivity
import kotlinx.android.synthetic.main.item_genre.view.*

class GenreViewHolder(
        itemView: View,
        private val listener: MainActivity
): RecyclerView.ViewHolder(itemView) {

    fun bind(genre: GenreEntity){
       itemView.itemGenre.text = genre.name

        itemView.setOnClickListener {
            listener.onClickGenre(genre)
        }
        }
}