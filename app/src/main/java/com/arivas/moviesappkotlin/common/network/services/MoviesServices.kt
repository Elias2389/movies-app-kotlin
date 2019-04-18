package com.arivas.moviesappkotlin.common.network.services

import com.arivas.moviesappkotlin.common.dto.MoviesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesServices {
    @GET("popular?")
    fun getPopularMovies(@Query("api_key") apiKey: String): Observable<MoviesResponse>
}