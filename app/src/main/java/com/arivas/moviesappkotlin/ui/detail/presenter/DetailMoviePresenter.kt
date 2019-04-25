package com.arivas.moviesappkotlin.ui.detail.presenter

import com.arivas.moviesappkotlin.common.dto.DetailMovie

interface DetailMoviePresenter {
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