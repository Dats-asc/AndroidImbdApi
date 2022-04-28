package com.example.androidimbdapi.di

import com.example.androidimbdapi.di.module.AppModule
import com.example.androidimbdapi.di.module.NetModule
import com.example.androidimbdapi.di.module.RepoModule
import dagger.Component

@Component(
    modules = [
        AppModule::class,
        NetModule::class,
        RepoModule::class
    ]
)
interface AppComponent {
}