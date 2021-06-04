package com.example.movie.di.module

import android.app.Application
import com.example.movie.MovieApp
import com.example.movie.di.scope.ViewModelScope
import com.example.movie.use_case.ActorInfoUseCase
import com.example.movie.use_case.FindAndShowMovieByIdUseCase
import com.example.movie.use_case.MovieUseCase
import com.example.movie.view_model.ActorInfoViewModel
import com.example.movie.view_model.DetailViewModel
import com.example.movie.view_model.MainViewModel
import dagger.Module
import dagger.Provides

@Module
class ViewModelModule (app:MovieApp) {
    internal var app: Application = app

    @ViewModelScope
    @Provides
    internal fun providesMainViewModel(movieUseCase: MovieUseCase):MainViewModel{
     return MainViewModel(movieUseCase)
    }

    @ViewModelScope
    @Provides
    internal fun providesDetailViewModel(findAndShowMovieByIdUseCase: FindAndShowMovieByIdUseCase):DetailViewModel{
        return DetailViewModel(findAndShowMovieByIdUseCase)

    }

    @ViewModelScope
    @Provides
    internal fun providesActorInfoViewModel(actorInfoUseCase: ActorInfoUseCase):ActorInfoViewModel{
        return ActorInfoViewModel(actorInfoUseCase)
    }



}

