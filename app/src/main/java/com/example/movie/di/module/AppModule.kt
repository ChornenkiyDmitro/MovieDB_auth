package com.example.movie.di.module

import android.app.Application
import com.example.movie.di.scope.AppScope
import com.google.gson.Gson
import dagger.Module
import dagger.Provides

@Module
class AppModule(private val app: Application) {
    @Provides
    @AppScope
    fun providesApplication(): Application {
        return app
    }

    @Provides
    @AppScope
    fun providesGson(): Gson {
        return Gson()
    }
}