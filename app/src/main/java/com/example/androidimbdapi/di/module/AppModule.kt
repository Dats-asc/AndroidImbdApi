package com.example.androidimbdapi.di.module

import android.app.Application
import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.androidimbdapi.data.mapper.ImbdMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideImbdMapper(): ImbdMapper = ImbdMapper()

    @Provides
    fun provideContext(app: Application): Context = app.applicationContext

    @Provides
    fun provideGlide(app: Application): RequestManager = Glide.with(app.applicationContext)
}