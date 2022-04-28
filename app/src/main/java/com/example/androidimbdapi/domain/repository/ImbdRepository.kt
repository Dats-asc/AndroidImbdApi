package com.example.androidimbdapi.domain.repository

import com.example.androidimbdapi.domain.entity.MovieSearch
import io.reactivex.rxjava3.core.Single

interface ImbdRepository {

    fun getMoviesByRequest(request: String) : Single<MovieSearch>
}