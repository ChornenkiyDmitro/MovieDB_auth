package com.example.movie.remote_data_source


import com.example.movie.data_source.database.entity.ActorEntity
import com.example.movie.data_source.database.entity.MovieEntity
import com.example.movie.data_source.database.entity.databaseconvertor.UserEntity
import com.example.movie.remote_data_source.pojo.*
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApi {
    companion object {
        const val API_KEY = "b581d6ee89ab3cabae62530b708351b2"

    }

    // Movies

    @GET("movie/popular")
    fun getPopularMovie(
            @Query("api_key") apiKey: String = API_KEY
    ): Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieById(
        @Path("movie_id") id: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): Single<MovieEntity>

    @GET("movie/{movie_id}/similar")
    fun getSimilarMovies(
            @Path("movie_id") id:Int,
            @Query("api_key")apiKey: String = API_KEY
    ):Single<MovieResponse>

    @GET("movie/{movie_id}/videos")
    fun getVideoById(
        @Path("movie_id")id: Int,
        @Query("api_key")apiKey: String = API_KEY
    ):Single<TrailerResponse>

    //Actor

    @GET("movie/{movie_id}/credits")
    fun getMovieCast(
            @Path("movie_id") id: Int,
            @Query("api_key") apiKey: String = API_KEY
    ): Single<CastResponse>

    @GET("person/{person_id}")
    fun getActor(
            @Path("person_id")id: Int,
            @Query("api_key") apiKey: String = API_KEY

    ):Single<ActorEntity>

    @GET("person/{person_id}/movie_credits")
    fun getActorListMovie(
        @Path("person_id")id:Int,
        @Query("api_key")apiKey:String = API_KEY
    ):Single<CastMovieResponse>

    @GET("search/person")
    fun getSearchActor(
        @Query("api_key")apiKey: String= API_KEY,
        @Query("query")name: String
    ):Single<SearchActorResponse>

    //Genre

    @GET("genre/movie/list")
    fun getGenreList (
            @Query("api_key")apiKey: String = API_KEY

    ):Single<GenresResponse>

    //Users

    @GET("/users")
    fun fetchUsers(): Single<Response<List<UserEntity>>?>

}


