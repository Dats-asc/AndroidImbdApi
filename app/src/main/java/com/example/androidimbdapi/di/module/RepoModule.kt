package com.example.androidimbdapi.di.module

import com.example.androidimbdapi.data.ImbdRepositoryImpl
import com.example.androidimbdapi.domain.repository.ImbdRepository
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {

    @Binds
    fun imbdRepository(
        impl: ImbdRepositoryImpl
    ) : ImbdRepository
}