package com.example.movie.main.actor

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.movie.MovieApp
import com.example.movie.R
import com.example.movie.data_source.database.entity.ActorEntity
import com.example.movie.data_source.database.entity.MovieEntity
import com.example.movie.main.actor.adapter.RecyclerActorMovieList
import com.example.movie.view_model.ActorInfoViewModel
import kotlinx.android.synthetic.main.activity_actor_info.*
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class ActorActivity: AppCompatActivity() {

    var actorInfoViewModel: ActorInfoViewModel? = null @Inject set
    var recyclerActorMovieList = RecyclerActorMovieList()
    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actor_info)

        (application as MovieApp).getViewModelComponent().inject(this)

        val id = intent.getIntExtra("actor_id",-1)

        actorInfoViewModel?.getActor(id)
        actorInfoViewModel?.getMovieActorList(id)
        writeInfo()
        writeList()
    }

    private fun writeList(){

        movieListActor.adapter = recyclerActorMovieList
        movieListActor.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        actorInfoViewModel?.gotActorMovie?.observe(this, Observer<List<MovieEntity>>{
            recyclerActorMovieList.setData(it)
        })
    }

    private fun writeInfo(){

        actorInfoViewModel?.gotActor?.observe(this, Observer<ActorEntity> {
                actor ->
            actorName.text = actor.name
            biographyActor.text = actor.biography
            if (biographyActor.text.equals("")){
                biographyActor.setText("no info")
            }

            Glide.with(this)
                .load(IMAGE_BASE + actor.profile_path)
                .into(actorPhoto)
        })
    }
}