package com.example.androidimbdapi.domain.usecase

import com.example.androidimbdapi.domain.entity.MovieSearch
import com.example.androidimbdapi.domain.repository.ImbdRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class getMoviesByRequestUseCase @Inject constructor(
    private val imbdRepository: ImbdRepository
) {

    operator fun invoke(
        request: String
    ): Single<MovieSearch> = imbdRepository.getMoviesByRequest(request)
        .subscribeOn(Schedulers.io())
}