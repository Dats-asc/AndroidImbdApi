package com.example.androidimbdapi.data

import com.example.androidimbdapi.data.response.MovieSearchResponse
import com.example.androidimbdapi.data.response.TitleResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

val apiKey = "k_8cudlidf"

interface ImbdApi {

    @GET("https://imdb-api.com/en/API/SearchMovie/k_8cudlidf/{request}")
    fun getMoviesByRequest(@Path("request") request: String) : Single<MovieSearchResponse>

    @GET("https://imdb-api.com/en/API/Title/k_8cudlidf/{id}")
    fun getTitle(@Path("id") id: String) : Single<TitleResponse>
}