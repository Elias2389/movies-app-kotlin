package com.arivas.moviesappkotlin.ui.movies.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.arivas.moviesappkotlin.R
import com.arivas.moviesappkotlin.common.dto.MoviesResponse
import com.arivas.moviesappkotlin.ui.movies.presenter.MoviesPresenter
import com.arivas.moviesappkotlin.ui.movies.presenter.MoviesPresenterImpl

class MoviesActivity : AppCompatActivity(), MoviesView {
    private var presenter: MoviesPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MoviesPresenterImpl(this)
        popularMovies()
    }

    override fun popularMovies() {
        presenter?.popularMovies()
    }

    override fun successPopularMovies(movies: MoviesResponse) {

    }

    override fun error() {

    }
}
