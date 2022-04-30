package com.example.androidimbdapi.di.module

import com.example.androidimbdapi.data.ImbdRepositoryImpl
import com.example.androidimbdapi.domain.repository.ImbdRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
interface RepoModule {

    @Binds
    fun imbdRepository(
        impl: ImbdRepositoryImpl
    ): ImbdRepository
}