package com.example.movie.data_source

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.movie.data_source.database.MovieDataBase
import com.example.movie.data_source.database.entity.ActorEntity
import com.example.movie.data_source.database.entity.GenreEntity
import com.example.movie.data_source.database.entity.MovieEntity
import io.reactivex.Completable
import io.reactivex.Single

interface DataSource {

    //Movie
    fun deleteMovie(): Completable
    fun showListMovie(): Single<List<MovieEntity>>
    fun insertListMovie(movieList: List<MovieEntity>): Completable
    fun showMovieInfo(id: Int): Single<MovieEntity>
    fun insertMovieInfo(movie: MovieEntity): Completable
    fun insertAndClearList(movieList: List<MovieEntity>): Completable
    fun insertAndClearMovieInfo(movie: MovieEntity): Completable

    //Actor
    fun deleteActor(): Completable
    fun showMovieCast(): Single<List<ActorEntity>>
    fun insertActor(actorList: List<ActorEntity>): Completable
    fun insertAndClearListActor(actorList: List<ActorEntity>): Completable
    fun showActorById(id: Int): Single<ActorEntity>
    fun insertActorInfo(actor: ActorEntity): Completable
    fun insertAndClearActor(actor: ActorEntity): Completable

    //Genre
    fun deleteGenre(): Completable
    fun showListGenre(): Single<List<GenreEntity>>
    fun insertListGenre(genrelist: List<GenreEntity>): Completable
    fun insertAndClearGenre(genre: List<GenreEntity>): Completable
}

class DataSourceImpl(private val movieDataBase: MovieDataBase) : DataSource {

    //Movie

    override fun deleteMovie(): Completable =
        Completable.fromAction {
            movieDataBase.MovieDao().deleteMovie()
        }

    override fun showListMovie(): Single<List<MovieEntity>> =
        movieDataBase.MovieDao().showListMovie()

    override fun insertListMovie(movieList: List<MovieEntity>): Completable =
        Completable.fromAction {
            movieDataBase.MovieDao().insertListMovie(movieList)
        }

    override fun showMovieInfo(id: Int): Single<MovieEntity> =
        movieDataBase.MovieDao().showMovieInfo(id = id)

    override fun insertMovieInfo(movie: MovieEntity): Completable =
        Completable.fromAction {
            movieDataBase.MovieDao().insertMovieInfo(movie)
        }

    override fun insertAndClearList(movieList: List<MovieEntity>): Completable =
        Completable.fromAction {
            movieDataBase.MovieDao().insertAndClearList(movieList)
        }

    override fun insertAndClearMovieInfo(movie: MovieEntity): Completable =
        Completable.fromAction {
            movieDataBase.MovieDao().insertAndClearMovieInfo(movie)
        }

    //Actor

    override fun deleteActor(): Completable =
        Completable.fromAction {
            movieDataBase.MovieDao().deleteActor()
        }

    override fun showMovieCast(): Single<List<ActorEntity>> =
        movieDataBase.MovieDao().showMovieCast()

    override fun insertActor(actorList: List<ActorEntity>): Completable =
        Completable.fromAction {
            movieDataBase.MovieDao().insertActor(actorList)
        }

    override fun insertAndClearListActor(actorList: List<ActorEntity>): Completable =
        Completable.fromAction {
            movieDataBase.MovieDao().insertAndClearListActor(actorList)
        }

    override fun showActorById(id: Int): Single<ActorEntity> =
        movieDataBase.MovieDao().showActorById(id)

    override fun insertActorInfo(actor: ActorEntity): Completable =
        Completable.fromAction {
            movieDataBase.MovieDao().insertActorInfo(actor)
        }

    override fun insertAndClearActor(actor: ActorEntity): Completable =
        Completable.fromAction {
            movieDataBase.MovieDao().insertAndClearActor(actor)
        }



    //Genre

    override fun deleteGenre(): Completable =
        Completable.fromAction {
            movieDataBase.MovieDao().deleteGenre()
        }

    override fun showListGenre(): Single<List<GenreEntity>> =
        movieDataBase.MovieDao().showListGenre()

    override fun insertListGenre(genre: List<GenreEntity>): Completable =
        Completable.fromAction {
            movieDataBase.MovieDao().insertListGenre(genre)
        }

    override fun insertAndClearGenre(genre: List<GenreEntity>): Completable =
        Completable.fromAction {
            movieDataBase.MovieDao().insertAndClearGenre(genre)
        }
}














