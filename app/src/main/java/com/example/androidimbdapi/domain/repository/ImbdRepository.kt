package com.example.androidimbdapi.domain.repository

import com.example.androidimbdapi.domain.entity.MovieSearch
import com.example.androidimbdapi.domain.entity.Title
import io.reactivex.rxjava3.core.Single

interface ImbdRepository {

    fun getMoviesByRequest(request: String): Single<MovieSearch>

    fun getTitle(id: String): Single<Title>
}