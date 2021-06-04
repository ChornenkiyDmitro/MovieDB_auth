package com.example.movie.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movie.MovieApp
import com.example.movie.R
import com.example.movie.data_source.database.entity.GenreEntity
import com.example.movie.data_source.database.entity.MovieEntity
import com.example.movie.main.adapter.GenreListener
import com.example.movie.main.adapter.GenreRecyclerAdapter
import com.example.movie.main.adapter.ItemMovieListener
import com.example.movie.main.adapter.RecyclerViewMainAdapter
import com.example.movie.presentation.detail.DetailActivity
import com.example.movie.presentation.profile.ProfileActivity
import com.example.movie.view_model.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), ItemMovieListener, GenreListener {
    var mainViewModel: MainViewModel? = null @Inject set
    val adapterListMovie = RecyclerViewMainAdapter(this)
    val adapterListGenre = GenreRecyclerAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MovieApp).getViewModelComponent().inject(this)

        recyclerListGenre.adapter = adapterListGenre
        recyclerListGenre.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerviewListMovie.adapter = adapterListMovie
        recyclerviewListMovie.layoutManager = LinearLayoutManager(this)

        showPopularList()
    }

    private fun showGenre() {
        recyclerListGenre.visibility = View.VISIBLE

        mainViewModel?.getListGenre()

        mainViewModel?.listGenre?.observe(this, Observer<List<GenreEntity>> {
            adapterListGenre.setData(it)
        })
    }

    private fun showPopularList() {

        mainViewModel?.getListPopularMovie()

        mainViewModel?.listMovie?.observe(this, Observer<List<MovieEntity>> {
            adapterListMovie.setData(it)
        })
    }

    override fun onClickMovie(movie: MovieEntity) {
        val nextScreen = Intent(this, DetailActivity::class.java)
            .putExtra("movie_id", movie.id)
        startActivity(nextScreen)
        Log.d("id_movie_info", "${movie.id}")


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.popular -> {
                editActorName.visibility = View.GONE
                recyclerListGenre.visibility = View.GONE
                buttonFind.visibility = View.GONE
                showPopularList()
                true
            }
            R.id.genre -> {
                editActorName.visibility = View.GONE
                buttonFind.visibility = View.GONE
                showGenre()
                return true
            }
            R.id.actor -> {
                recyclerListGenre.visibility = View.GONE
                showByActorName()
                return true
            }

            R.id.profile -> {
                editActorName.visibility = View.GONE
                recyclerListGenre.visibility = View.GONE
                buttonFind.visibility = View.GONE
                startNextActivity()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onClickGenre(genre: GenreEntity) {
        recyclerListGenre.visibility = View.GONE
        mainViewModel?.getMovieByGenre(genre.id)

        mainViewModel?.listMovie?.observe(this, Observer<List<MovieEntity>> {
            adapterListMovie.setData(it)
        })
    }

    private fun startNextActivity() {
        val nextScreen = Intent(this, ProfileActivity::class.java)
        startActivity(nextScreen)
    }

    private fun showByActorName() {
        editActorName.visibility = View.VISIBLE
        buttonFind.visibility = View.VISIBLE

        buttonFind.setOnClickListener {

            var actorName = editActorName.text.toString()

            if (actorName.isNotEmpty()) {

                mainViewModel?.getMovieListByActor(actorName)

                mainViewModel?.listMovie?.observe(this, Observer<List<MovieEntity>> {
                    if (it == null) {
                        Toast.makeText(this, "Error, list not found", Toast.LENGTH_LONG).show()
                    } else {
                        adapterListMovie.setData(it)
                    }
                })
            } else {
                Toast.makeText(this, "Error, write actor name", Toast.LENGTH_LONG).show()
            }
        }
    }
}
