package com.example.movie.main


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.movie.MovieApp
import com.example.movie.di.component.ViewModelComponent
import com.google.firebase.auth.FirebaseAuth

abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createDaggerDependencies()
    }

    protected abstract fun injectDependency(component: ViewModelComponent)

    private fun createDaggerDependencies() {
        injectDependency((application as MovieApp).getViewModelComponent())
    }
}