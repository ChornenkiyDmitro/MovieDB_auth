package com.example.movie.di.component

import com.example.movie.di.module.NetworkModule
import com.example.movie.di.scope.NetworkScope
import com.example.movie.remote_data_source.RemoteDataSource
import dagger.Component

@NetworkScope
@Component(modules = [NetworkModule::class],dependencies = [AppComponent::class])
interface NetworkComponent {
    val repositoryNetworkScope:RemoteDataSource
}