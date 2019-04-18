package com.arivas.moviesappkotlin.ui.movies.interactor

import com.arivas.moviesappkotlin.common.dto.MoviesResponse

interface MoviesInteractor {
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