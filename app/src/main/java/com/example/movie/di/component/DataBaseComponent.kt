package com.example.movie.di.component


import com.example.movie.data_source.DataSource
import com.example.movie.di.module.DataBaseModule
import dagger.Component


@Component(modules = [DataBaseModule::class])
interface DataBaseComponent {
    val dataSource:DataSource
}