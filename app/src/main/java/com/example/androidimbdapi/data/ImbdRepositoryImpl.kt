package com.example.androidimbdapi.data

import com.example.androidimbdapi.data.mapper.ImbdMapper
import com.example.androidimbdapi.domain.entity.MovieSearch
import com.example.androidimbdapi.domain.entity.Title
import com.example.androidimbdapi.domain.repository.ImbdRepository
import io.reactivex.rxjava3.core.Single
import okhttp3.OkHttpClient
import javax.inject.Inject

class ImbdRepositoryImpl @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val imbdApi: ImbdApi,
    private val imbdMapper: ImbdMapper
): ImbdRepository {

    override fun getMoviesByRequest(
        request: String
    ): Single<MovieSearch> =
        imbdApi.getMoviesByRequest(request)
            .map {
                imbdMapper.mapSearchMovieResponse(it)
            }

    override fun getTitle(id: String): Single<Title> =
        imbdApi.getTitle(id)
            .map {
                imbdMapper.mapTitle(it)
            }
}