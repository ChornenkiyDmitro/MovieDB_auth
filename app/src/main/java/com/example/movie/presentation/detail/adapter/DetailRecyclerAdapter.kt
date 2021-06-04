package com.example.movie.presentation.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.movie.R
import com.example.movie.data_source.database.entity.ActorEntity
import com.example.movie.presentation.detail.DetailActivity

class DetailRecyclerAdapter(
        private val listener: DetailActivity
): RecyclerView.Adapter<DetailViewHolder>() {

    private var actorlist = mutableListOf<ActorEntity>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        return DetailViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.item_actor, parent, false),
                  listener
        )
    }

    override fun getItemCount(): Int = actorlist.size

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(actorlist[position])
    }

    fun setData(actor: List<ActorEntity>) {
        actorlist.clear()
        actorlist.addAll(actor)
        notifyDataSetChanged()
    }
}