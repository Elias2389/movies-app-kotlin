package com.arivas.moviesappkotlin.ui.detail.interactor

import android.annotation.SuppressLint
import android.util.Log
import com.arivas.moviesappkotlin.BuildConfig
import com.arivas.moviesappkotlin.common.dto.DetailMovie
import com.arivas.moviesappkotlin.common.dto.MoviesResponse
import com.arivas.moviesappkotlin.common.network.RetrofitService
import com.arivas.moviesappkotlin.common.network.services.MoviesServices
import com.arivas.moviesappkotlin.ui.detail.presenter.DetailMoviePresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class DetailMovieInteractorImpl(private val presenter: DetailMoviePresenter, private val service: RetrofitService):
    DetailMovieInteractor {

    @SuppressLint("CheckResult")
    override fun detailMovie(movieId: Int) {
        getCall(movieId)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ response ->
                successDetailMovie(response)
            },{ error ->
                Log.e("Error,", error.message)
                error()
            })
    }

    override fun successDetailMovie(detailMovie: DetailMovie) {
        presenter.successDetailMovie(detailMovie)
    }

    override fun error() {
        presenter.error()
    }

    private fun getService(): MoviesServices {
        return service.client().create(MoviesServices::class.java)
    }

    private fun getCall(movieId: Int): Observable<DetailMovie> {
        return getService().getDetailMovie(movieId, BuildConfig.API_KEY)
    }
}