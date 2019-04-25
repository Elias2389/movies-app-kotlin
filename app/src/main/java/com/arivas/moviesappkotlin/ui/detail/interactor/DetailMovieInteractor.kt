package com.arivas.moviesappkotlin.ui.detail.interactor

import com.arivas.moviesappkotlin.common.dto.DetailMovie

interface DetailMovieInteractor {
    /**
     * Get popular movies
     */
    fun detailMovie(movieId: Int)

    /**
     * Success popular movies
     */
    fun successDetailMovie(detailMovie: DetailMovie)

    /**
     * On error
     */
    fun error()

}