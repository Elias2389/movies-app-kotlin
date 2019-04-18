package com.arivas.moviesappkotlin.ui.movies.view

import com.arivas.moviesappkotlin.common.dto.MoviesResponse

interface MoviesView {
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