package com.arivas.moviesappkotlin.ui.detail.presenter

import com.arivas.moviesappkotlin.common.dto.DetailMovie
import com.arivas.moviesappkotlin.common.network.RetrofitService
import com.arivas.moviesappkotlin.ui.detail.interactor.DetailMovieInteractor
import com.arivas.moviesappkotlin.ui.detail.interactor.DetailMovieInteractorImpl
import com.arivas.moviesappkotlin.ui.detail.view.DetailMovieView

class DetailMoviePresenterImpl(private val view: DetailMovieView, private val service: RetrofitService):
    DetailMoviePresenter {

    private val interactor: DetailMovieInteractor = DetailMovieInteractorImpl(this, service)

    override fun detailMovie(movieId: Int) {
        interactor.detailMovie(movieId)
    }

    override fun successDetailMovie(detailMovie: DetailMovie) {
        view.successDetailMovie(detailMovie)
    }

    override fun error() {
        view.error()
    }
}