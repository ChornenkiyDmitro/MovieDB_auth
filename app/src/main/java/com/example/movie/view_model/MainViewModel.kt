package com.example.movie.view_model

import androidx.lifecycle.MutableLiveData
import com.example.movie.data_source.database.entity.GenreEntity
import com.example.movie.data_source.database.entity.MovieEntity
import com.example.movie.use_case.MovieUseCase
import io.reactivex.rxkotlin.plusAssign

class MainViewModel(
    private val movieUseCase: MovieUseCase
) : BaseViewModel() {

    val listMovie = MutableLiveData<List<MovieEntity>>()
    val listGenre = MutableLiveData<List<GenreEntity>>()

    private fun showListMovie() {
        compositeDisposable += movieUseCase.showListMovie()
            .subscribe({ list ->
                listMovie.value = list
            }, {
                it.printStackTrace()
            })
    }

     fun getListPopularMovie(){
         compositeDisposable += movieUseCase.getPopularMovie()
                         .subscribe({
                     showListMovie()
                 },{
                     it.printStackTrace()

                 })
     }


    private fun showListGenre(){
        compositeDisposable += movieUseCase.showListGenre()
                .subscribe({ list ->
                    listGenre.value = list
                }, {
                    it.printStackTrace()
                })
    }

    fun getListGenre(){
        compositeDisposable += movieUseCase.getGenreList()
                .subscribe({
                    showListGenre()
                }, {
                    it.printStackTrace()
                })
    }

    fun getMovieListByActor(name: String){
        compositeDisposable += movieUseCase.getSearchActor(name = name)
            .subscribe({
                showMovieByActor()
            }, {
                it.printStackTrace()
            })
    }

    private fun showMovieByActor(){
        compositeDisposable += movieUseCase.showListMovie()
            .subscribe({
                list ->
                listMovie.value = list
            }, {
              it.printStackTrace()
            })
    }


    fun getMovieByGenre(id: Int){
        compositeDisposable += movieUseCase.getSimilarMovie(id)
            .subscribe({
                showMovieByGenre()
            }, {
                it.printStackTrace()
            })
    }

    private fun showMovieByGenre(){
        compositeDisposable += movieUseCase.showListMovie()
            .subscribe({
                list->
                listMovie.value =list
            }, {
                it.printStackTrace()
            })
    }
}
