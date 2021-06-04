package com.example.movie.di.component

import android.app.Activity
import com.example.movie.di.module.ViewModelModule
import com.example.movie.di.scope.ViewModelScope
import com.example.movie.main.MainActivity
import com.example.movie.main.actor.ActorActivity
import com.example.movie.presentation.detail.DetailActivity
import dagger.Component

@ViewModelScope
@Component(modules = [ViewModelModule::class],dependencies = [UseCaseComponent::class])
interface ViewModelComponent {
    fun inject(activity: MainActivity)

    fun inject(activity: DetailActivity)

    fun inject(activity: ActorActivity)
}