package com.example.androidimbdapi.di.module

import com.example.androidimbdapi.data.mapper.ImbdMapper
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideImbdMapper(): ImbdMapper = ImbdMapper()
}