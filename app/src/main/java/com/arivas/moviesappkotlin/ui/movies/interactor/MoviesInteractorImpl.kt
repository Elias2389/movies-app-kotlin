package com.arivas.moviesappkotlin.ui.movies.interactor


import android.annotation.SuppressLint
import android.util.Log
import com.arivas.moviesappkotlin.BuildConfig
import com.arivas.moviesappkotlin.common.dto.MoviesResponse
import com.arivas.moviesappkotlin.common.network.RetrofitService
import com.arivas.moviesappkotlin.common.network.services.MoviesServices
import com.arivas.moviesappkotlin.ui.movies.presenter.MoviesPresenter
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MoviesInteractorImpl(private val presenter: MoviesPresenter, private val service: RetrofitService): MoviesInteractor {

    @SuppressLint("CheckResult")
    override fun popularMovies() {
        getCall()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ response ->
                successPopularMovies(response)
            },{ error ->
                Log.e("Error,", error.message)
                error()
            })
    }

    override fun successPopularMovies(movies: MoviesResponse) {
        presenter.successPopularMovies(movies)
    }

    override fun error() {
        presenter.error()
    }

    private fun getService(): MoviesServices {
        return service.client().create(MoviesServices::class.java)
    }

    private fun getCall(): Observable<MoviesResponse> {
        return getService().getPopularMovies(BuildConfig.API_KEY)
    }
}