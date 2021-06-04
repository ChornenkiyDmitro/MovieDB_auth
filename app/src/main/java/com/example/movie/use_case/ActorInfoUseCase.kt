package com.example.movie.use_case

import com.example.movie.data_source.database.entity.ActorEntity
import com.example.movie.data_source.database.entity.MovieEntity
import com.example.movie.repository.MovieRepository
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface ActorInfoUseCase {

    //actor
    fun showActorById(id: Int): Single<ActorEntity>
    fun getActor(id: Int): Completable
    fun deleteActor(): Completable

    //movie
    fun getActorListMovie(id: Int): Completable
    fun deleteMovie(): Completable
    fun showListMovie(): Single<List<MovieEntity>>
}

class ActorInfoUseCaseImpl(
        private val repository: MovieRepository
) : ActorInfoUseCase {
    override fun showActorById(id: Int): Single<ActorEntity> =
            repository.showActorById(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())


    override fun getActor(id: Int): Completable =
            repository.getActor(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    override fun deleteActor(): Completable =
            repository.deleteActor()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    override fun getActorListMovie(id: Int): Completable =
            repository.getActorListMovie(id)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    override fun deleteMovie(): Completable =
            repository.deleteMovie()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    override fun showListMovie(): Single<List<MovieEntity>> =
            repository.showListMovie()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
}


