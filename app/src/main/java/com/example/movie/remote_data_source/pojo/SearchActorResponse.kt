package com.example.movie.remote_data_source.pojo


import com.google.gson.annotations.SerializedName

data class SearchActorResponse(

    @SerializedName("results")
    val results: List<KnownForResponse>
)

