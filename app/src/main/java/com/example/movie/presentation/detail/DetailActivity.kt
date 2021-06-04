package com.example.movie.presentation.detail

import android.content.Intent
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
import com.example.movie.main.actor.ActorActivity
import com.example.movie.presentation.detail.adapter.ActorMovieListener
import com.example.movie.presentation.detail.adapter.DetailRecyclerAdapter
import com.example.movie.remote_data_source.pojo.KeyVideo
import com.example.movie.view_model.DetailViewModel
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.channels.actor
import javax.inject.Inject

class DetailActivity : AppCompatActivity(), ActorMovieListener {

    var detailViewModel: DetailViewModel? = null @Inject set
    val adapterListActor = DetailRecyclerAdapter (this)

    private val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        (application as MovieApp).getViewModelComponent().inject(this)



        val id = intent.getIntExtra("movie_id",-1)
        detailViewModel?.getMovie(id)
        detailViewModel?.getMovieCast(id)
        detailViewModel?.getVideoById(id)

        writeMovieInfo()
        writeActorList()
        initYoutube()

    }

    private fun initYoutube(){

        var youtubeFragment = supportFragmentManager.findFragmentById(R.id.fragmentYoutube)
                as YouTubePlayerSupportFragment

        detailViewModel?.gotVideoById?.observe(this, Observer<List<KeyVideo>>{
            it.lastOrNull()?.let { key ->

                youtubeFragment.initialize(R.string.api_key.toString(), object : YouTubePlayer.OnInitializedListener{
                    override fun onInitializationSuccess(
                        p0: YouTubePlayer.Provider?,
                        p1: YouTubePlayer?,
                        p2: Boolean
                    ) {
                        if (p1 == null) return
                        if(p2)
                            p1.play()
                        else{
                            p1.cueVideo(key.key)
                            p1.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT)
                        }
                    }

                    override fun onInitializationFailure(
                        p0: YouTubePlayer.Provider?,
                        p1: YouTubeInitializationResult?
                    ) {
                    }

                })
            }
        })



    }

    private fun writeActorList() {
        recyclerListActorsDetail.adapter = adapterListActor
        recyclerListActorsDetail.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        detailViewModel?.gotMovieCast?.observe(this, Observer<List<ActorEntity>>{
            adapterListActor.setData(it)
        })
    }


    private fun writeMovieInfo() {

            detailViewModel?.gotMovie?.observe(this, Observer<MovieEntity>{
                movie ->
                textTitleDetail.text = movie.title


                //Todo make good looking format
                textGenreDetail.text = movie.overview?.map { it.name }.toString()
                textvoteAverageDetail.text =movie.voteAverage
                Glide.with(this)
                    .load(IMAGE_BASE + movie.posterPath)
                    .into(imageMoviePosterDetail)
            })
        }

    override fun onClickActor(actor: ActorEntity) {
        val nextScreen = Intent(this, ActorActivity::class.java)
                .putExtra("actor_id", actor.id)
        startActivity(nextScreen)
    }
}
