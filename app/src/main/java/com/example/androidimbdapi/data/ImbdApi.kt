package com.example.androidimbdapi.data

import com.example.androidimbdapi.data.response.MovieSearchResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

val apiKey = "k_8cudlidf"

interface ImbdApi {

    @GET("https://imdb-api.com/en/API/SearchMovie/k_8cudlidf/{requset}")
    fun getMoviesByRequest(@Path("request") request: String) : Single<MovieSearchResponse>
}