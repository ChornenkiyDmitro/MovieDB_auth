package com.example.movie.di.scope

import java.lang.annotation.RetentionPolicy
import javax.inject.Scope
import java.lang.annotation.Retention

@Scope
@Retention(RetentionPolicy.CLASS)
annotation class AppScope
