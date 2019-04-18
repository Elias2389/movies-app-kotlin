package com.arivas.moviesappkotlin.ui.movies.presenter

import com.arivas.moviesappkotlin.common.dto.MoviesResponse

interface MoviesPresenter {
    /**
     * Get popular movies
     */
    fun popularMovies()

    /**
     * Success popular movies
     */
    fun successPopularMovies(movies: MoviesResponse)

    /**
     * On error
     */
    fun error()
}