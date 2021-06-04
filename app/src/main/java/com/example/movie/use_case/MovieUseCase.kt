package com.example.movie.use_case

import com.example.movie.data_source.database.entity.GenreEntity
import com.example.movie.data_source.database.entity.MovieEntity
import com.example.movie.repository.MovieRepository
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


interface MovieUseCase {
    //Movie
    fun getPopularMovie(): Completable
    fun deleteMovie(): Completable
    fun showListMovie(): Single<List<MovieEntity>>
    fun getSimilarMovie(id: Int): Completable

    //Genre
    fun getGenreList(): Completable
    fun deleteGenre(): Completable
    fun showListGenre(): Single<List<GenreEntity>>

    //Actor
    fun getSearchActor(name:String):Completable
}

class MovieUseCaseImpl(
        private val repository: MovieRepository
) : MovieUseCase {

    //Movie

    override fun getPopularMovie(): Completable =
            repository.getPopularMovie()
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

    override fun getSimilarMovie(id: Int): Completable =
        repository.getSimilarMovie(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    //Genre

    override fun getGenreList(): Completable =
            repository.getGenreList()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    override fun deleteGenre(): Completable =
            repository.deleteGenre()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    override fun showListGenre(): Single<List<GenreEntity>> =
            repository.showListGenre()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())

    override fun getSearchActor(name: String): Completable =
        repository.getSearchActor(name)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


}
