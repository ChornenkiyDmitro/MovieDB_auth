package com.example.movie.repository

import com.example.movie.data_source.DataSource
import com.example.movie.data_source.database.entity.ActorEntity
import com.example.movie.data_source.database.entity.GenreEntity
import com.example.movie.data_source.database.entity.MovieEntity
import com.example.movie.remote_data_source.RemoteDataSource
import com.example.movie.remote_data_source.pojo.KeyVideo
import io.reactivex.Completable
import io.reactivex.Single

interface MovieRepository {

    //Movie
    fun getPopularMovie(): Completable
    fun deleteMovie(): Completable
    fun showListMovie(): Single<List<MovieEntity>>
    fun getMovieById(id: Int): Completable
    fun showMovieInfo(id: Int): Single<MovieEntity>
    fun getSimilarMovie(id: Int): Completable
    fun getVideoById(id: Int):Single<List<KeyVideo>>

    //Actor
    fun getMovieCast(id: Int): Completable
    fun deleteActor(): Completable
    fun showMovieCast(): Single<List<ActorEntity>>
    fun showActorById(id: Int): Single<ActorEntity>
    fun getActor(id: Int): Completable
    fun getActorListMovie(id: Int):Completable
    fun getSearchActor(name:String):Completable

    //Genre
    fun getGenreList():Completable
    fun deleteGenre(): Completable
    fun showListGenre(): Single<List<GenreEntity>>

}

class MovieRepositoryImpl(
        private val dataSource: DataSource,
        private val remoteDataSource: RemoteDataSource
) : MovieRepository {

    //Movie
    override fun getPopularMovie(): Completable {
        return remoteDataSource.getPopularMovie()
            .flatMapCompletable { list ->
                saveListMovie(itemsMovie = list)
            }
    }

    override fun deleteMovie(): Completable {
        return dataSource.deleteMovie()
    }

    override fun showListMovie(): Single<List<MovieEntity>> {
        return dataSource.showListMovie()
    }

    override fun getMovieById(id: Int): Completable {
        return remoteDataSource.getMovieById(id)
            .flatMapCompletable { movie ->
                saveMovieInfo(movieEntity = movie, isCached = true)
            }
    }

    override fun showMovieInfo(id: Int): Single<MovieEntity> {
        return dataSource.showMovieInfo(id)
    }

    override fun getSimilarMovie(id: Int): Completable {
        return remoteDataSource.getSimilarMovies(id)
            .flatMapCompletable { similarMovie ->
                saveListMovie(itemsMovie = similarMovie)
            }
    }

    private fun saveListMovie(
        itemsMovie: List<MovieEntity>
    ): Completable {

        return dataSource.insertAndClearList(itemsMovie)
    }

    private fun saveMovieInfo(
        movieEntity: MovieEntity, isCached: Boolean
    ): Completable {
        if (isCached) {
            return dataSource.insertMovieInfo(movieEntity)
        } else {
            return dataSource.insertAndClearMovieInfo(movieEntity)
        }
    }

    override fun getVideoById(id: Int): Single<List<KeyVideo>>{
        return remoteDataSource.getVideosById(id)

    }

    //Actor
    override fun getMovieCast(id: Int): Completable {
        return remoteDataSource.getMovieCast(id)
            .flatMapCompletable { actor ->
                saveActorList(actorItem = actor)
            }
    }

    override fun deleteActor(): Completable {
        return dataSource.deleteActor()
    }

    override fun showMovieCast(): Single<List<ActorEntity>> {
        return dataSource.showMovieCast()
    }

    override fun showActorById(id: Int): Single<ActorEntity> {
        return dataSource.showActorById(id = id)
    }

    override fun getActor(id: Int): Completable {
        return remoteDataSource.getActor(id)
            .flatMapCompletable { actor ->
                saveActor(actor = actor)
            }

    }

    override fun getActorListMovie(id: Int): Completable {
        return remoteDataSource.getActorListMovie(id)
            .flatMapCompletable { actor ->
                saveListMovieActor(itemsMovie = actor)
            }
    }

    override fun getSearchActor(name: String): Completable {
        return  remoteDataSource.getSearchActor(name = name)
            .flatMapCompletable { foundActor ->
                saveListMovie(itemsMovie = foundActor)
            }
    }


    private fun saveListMovieActor(
            itemsMovie: List<MovieEntity>
    ): Completable {
            return dataSource.insertAndClearList(itemsMovie)
        }

    private fun saveActorList(
            actorItem: List<ActorEntity>
    ): Completable {
        return dataSource.insertAndClearListActor(actorItem)
    }

    private fun saveActor(
            actor: ActorEntity
    ): Completable {
        return dataSource.insertAndClearActor(actor)
    }


    //Genre

    override fun getGenreList(): Completable {
        return remoteDataSource.getGenreList()
                .flatMapCompletable {
                    saveListGenre(genres = it)
                }
    }

    override fun deleteGenre(): Completable {
        return dataSource.deleteGenre()
    }

    override fun showListGenre(): Single<List<GenreEntity>> {
        return dataSource.showListGenre()
    }

    private fun saveListGenre(
            genres: List<GenreEntity>
    ): Completable {
        return dataSource.insertAndClearGenre(genres)
    }
}


