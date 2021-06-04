package com.example.movie.di.component

import com.example.movie.di.module.AppModule
import com.example.movie.di.scope.AppScope
import com.google.gson.Gson
import dagger.Component


@AppScope
@Component(modules = [AppModule::class])
interface AppComponent {
    val gson:Gson
}