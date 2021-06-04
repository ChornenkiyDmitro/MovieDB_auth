package com.example.movie.remote_data_source


import com.example.movie.data_source.database.entity.ActorEntity
import com.example.movie.data_source.database.entity.GenreEntity
import com.example.movie.data_source.database.entity.MovieEntity
import com.example.movie.remote_data_source.mapper.mapToMovies
import com.example.movie.remote_data_source.pojo.KeyVideo
import io.reactivex.Single

interface RemoteDataSource {

    //Movie
    fun getPopularMovie():Single<List<MovieEntity>>
    fun getMovieById(id: Int):Single<MovieEntity>
    fun getSimilarMovies(id: Int):Single<List<MovieEntity>>
    fun getVideosById(id: Int):Single<List<KeyVideo>>

    //Actor
    fun getMovieCast(id: Int):Single<List<ActorEntity>>
    fun getActor(id: Int):Single<ActorEntity>
    fun getActorListMovie(id: Int):Single<List<MovieEntity>>
    fun getSearchActor(name:String):Single<List<MovieEntity>>

    //Genre
    fun getGenreList():Single<List<GenreEntity>>

}

class RemoteDataSourceImpl(private val movieApi: MovieApi):RemoteDataSource{

    //Movie

    override fun getPopularMovie(): Single<List<MovieEntity>> {
        return movieApi.getPopularMovie().map { it.result }
    }

    override fun getMovieById(id: Int): Single<MovieEntity> {
    return movieApi.getMovieById(id = id)
    }

    override fun getSimilarMovies(id: Int): Single<List<MovieEntity>> {
        return movieApi.getSimilarMovies(id =id).map { it.result }
    }

    override fun getVideosById(id: Int): Single<List<KeyVideo>> {
        return movieApi.getVideoById(id = id).map {
            it.result
        }
    }

    //Actor

    override fun getMovieCast(id: Int): Single<List<ActorEntity>> {
        return movieApi.getMovieCast(id).map { it.cast }
    }

    override fun getActor(id: Int):Single<ActorEntity>{
        return movieApi.getActor(id = id)
    }

    override fun getActorListMovie(id: Int): Single<List<MovieEntity>> {
        return movieApi.getActorListMovie(id = id).map { it.cast }
    }

    override fun getSearchActor(name: String): Single<List<MovieEntity>> {
        return movieApi.getSearchActor(name =name).map {
            it.results.mapToMovies()
        }
    }


    override fun getGenreList(): Single<List<GenreEntity>> {
            return movieApi.getGenreList().map {
                it.genres
            }
        }


    }
