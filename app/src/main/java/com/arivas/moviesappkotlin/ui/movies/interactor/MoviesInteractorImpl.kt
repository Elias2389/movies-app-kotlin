package com.arivas.moviesappkotlin.ui.movies.interactor


import com.arivas.moviesappkotlin.BuildConfig
import com.arivas.moviesappkotlin.common.dto.MoviesResponse
import com.arivas.moviesappkotlin.common.network.RetrofitService
import com.arivas.moviesappkotlin.common.network.services.MoviesServices
import com.arivas.moviesappkotlin.ui.movies.presenter.MoviesPresenter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesInteractorImpl(private val presenter: MoviesPresenter): MoviesInteractor {

    override fun popularMovies() {
        val response: Call<MoviesResponse> = getService().getPopularMovies(BuildConfig.API_KEY)
        response.enqueue(object: Callback<MoviesResponse>{
            override fun onFailure(call: Call<MoviesResponse>, t: Throwable) {
                error()
            }

            override fun onResponse(call: Call<MoviesResponse>, response: Response<MoviesResponse>) {
                successPopularMovies(response.body()!!)
            }
        })
    }

    override fun successPopularMovies(movies: MoviesResponse) {
        presenter.successPopularMovies(movies)
    }

    override fun error() {
        presenter.error()
    }

    fun getService(): MoviesServices {
        return RetrofitService.client().create(MoviesServices::class.java)
    }
}