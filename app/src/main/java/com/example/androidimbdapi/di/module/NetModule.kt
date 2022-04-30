package com.example.androidimbdapi.di.module

import com.example.androidimbdapi.data.ImbdApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    private val BASE_URL = "https://imdb-api.com/"

    @Provides
    fun okhttp(): OkHttpClient =
        OkHttpClient.Builder()
            .build()
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideRxJavaCallAdapter(): RxJava3CallAdapterFactory = RxJava3CallAdapterFactory.create()

    @Provides
    fun api(
        okHttpClient: OkHttpClient,
        gsonConverterFactory: GsonConverterFactory,
        rxJava3CallAdapterFactory: RxJava3CallAdapterFactory
    ): ImbdApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(gsonConverterFactory)
        .addCallAdapterFactory(rxJava3CallAdapterFactory)
        .build()
        .create(ImbdApi::class.java)
}