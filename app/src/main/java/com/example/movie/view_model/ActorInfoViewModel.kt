package com.example.movie.view_model

import androidx.lifecycle.MutableLiveData
import com.example.movie.data_source.database.entity.ActorEntity
import com.example.movie.data_source.database.entity.MovieEntity
import com.example.movie.use_case.ActorInfoUseCase
import io.reactivex.rxkotlin.plusAssign

class ActorInfoViewModel(
        private val actorInfoUseCase: ActorInfoUseCase
) : BaseViewModel() {

    val gotActor = MutableLiveData<ActorEntity>()
    val gotActorMovie = MutableLiveData<List<MovieEntity>>()

    fun getActor(id: Int) {
        compositeDisposable += actorInfoUseCase.getActor(id = id)
                .subscribe({
                    showActor(id)
                }, {
                    it.printStackTrace()

                })
    }

    private fun showActor(id: Int) {
        compositeDisposable += actorInfoUseCase.showActorById(id)
                .subscribe({ actor ->
                    gotActor.value = actor
                }, {
                    it.printStackTrace()
                })
    }

    fun getMovieActorList(id: Int){
        compositeDisposable += actorInfoUseCase.getActorListMovie(id)
            .subscribe({
                showMovie()
            },{
                it.printStackTrace()
            })
    }
    private fun showMovie(){
        compositeDisposable += actorInfoUseCase.showListMovie()
            .subscribe({ movie ->
                gotActorMovie.value = movie
            }, {
                it.printStackTrace()
            })
    }
}