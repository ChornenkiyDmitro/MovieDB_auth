package com.example.movie.di.component

import com.example.movie.di.module.UseCaseModule
import com.example.movie.di.scope.UseCaseScope
import com.example.movie.use_case.ActorInfoUseCase
import com.example.movie.use_case.FindAndShowMovieByIdUseCase
import com.example.movie.use_case.MovieUseCase
import dagger.Component


@UseCaseScope
@Component(modules = [UseCaseModule::class],dependencies = [RepositoryComponent::class])
interface UseCaseComponent {
    val movieUseCase:MovieUseCase
    val findAndShowMovieByIdUseCase:FindAndShowMovieByIdUseCase
    val actorInfoUseCase:ActorInfoUseCase
}