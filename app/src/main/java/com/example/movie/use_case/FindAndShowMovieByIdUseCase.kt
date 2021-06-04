package com.example.movie.use_case

import com.example.movie.data_source.database.entity.ActorEntity
import com.example.movie.data_source.database.entity.MovieEntity
import com.example.movie.remote_data_source.pojo.KeyVideo
import com.example.movie.repository.MovieRepository
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

interface FindAndShowMovieByIdUseCase {

    //Movie
    fun getMovieById(id: Int):Completable
    fun deleteMovie():Completable
    fun showMovieInfo(id: Int): Single<MovieEntity>
    fun getVideoById(id: Int):Single<List<KeyVideo>>

    //Actor
    fun getMovieCast(id: Int): Completable
    fun deleteActor(): Completable
    fun showMovieCast(): Single<List<ActorEntity>>
}
class FindAndShowMovieByIdUseCaseImpl(
        private val repository: MovieRepository
):FindAndShowMovieByIdUseCase{

    //Movie
    override fun getMovieById(id: Int): Completable {
        return repository.getMovieById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun deleteMovie(): Completable {
        return repository.deleteMovie()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun showMovieInfo(id: Int): Single<MovieEntity> {
        return repository.showMovieInfo(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getVideoById(id: Int): Single<List<KeyVideo>> {
        return repository.getVideoById(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())


    }

    //Actor
    override fun getMovieCast(id: Int): Completable {
        return repository.getMovieCast(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun deleteActor(): Completable {
        return repository.deleteActor()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

    override fun showMovieCast(): Single<List<ActorEntity>> {
        return repository.showMovieCast()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }

}