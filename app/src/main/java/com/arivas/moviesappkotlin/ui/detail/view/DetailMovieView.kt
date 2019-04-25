package com.arivas.moviesappkotlin.ui.detail.view

import com.arivas.moviesappkotlin.common.dto.DetailMovie

interface DetailMovieView {
    /**
     * Get popular movies
     */
    fun detailMovie()

    /**
     * Success popular movies
     */
    fun successDetailMovie(detailMovie: DetailMovie)

    /**
     * On error
     */
    fun error()

    /**
     * Create presenter
     */
    fun createPresenter()
}