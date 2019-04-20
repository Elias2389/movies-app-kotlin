package com.arivas.moviesappkotlin.ui.movies.presenter

import com.arivas.moviesappkotlin.common.dto.MoviesResponse
import com.arivas.moviesappkotlin.common.network.RetrofitService
import com.arivas.moviesappkotlin.ui.movies.interactor.MoviesInteractor
import com.arivas.moviesappkotlin.ui.movies.interactor.MoviesInteractorImpl
import com.arivas.moviesappkotlin.ui.movies.view.MoviesView

class MoviesPresenterImpl(private val view: MoviesView, private val service: RetrofitService): MoviesPresenter {

    private val interactor: MoviesInteractor = MoviesInteractorImpl(this, service)

    override fun popularMovies() {
        interactor.popularMovies()
    }

    override fun successPopularMovies(movies: MoviesResponse) {
        view.successPopularMovies(movies)
    }

    override fun error() {
        view.error()
    }
}