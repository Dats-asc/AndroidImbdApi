package com.example.androidimbdapi.domain.usecase

import com.example.androidimbdapi.domain.entity.MovieSearch
import com.example.androidimbdapi.domain.entity.Title
import com.example.androidimbdapi.domain.repository.ImbdRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class getTitleUseCase @Inject constructor(
    private val imbdRepository: ImbdRepository
) {

    operator fun invoke(
        id: String
    ): Single<Title> = imbdRepository.getTitle(id)
        .subscribeOn(Schedulers.io())
}