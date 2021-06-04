package com.example.movie.di.component

import com.example.movie.di.module.RepositoryModule
import com.example.movie.di.scope.RepositoryScope
import com.example.movie.repository.MovieRepository
import dagger.Component

@RepositoryScope
@Component(
    modules = [RepositoryModule::class],
    dependencies = [NetworkComponent::class, DataBaseComponent::class]
)
interface RepositoryComponent {
    val movieRepository:MovieRepository

}