package com.arivas.moviesappkotlin.ui.detail.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.arivas.moviesappkotlin.R
import com.arivas.moviesappkotlin.common.dto.DetailMovie
import kotlinx.android.synthetic.main.activity_detail_movie.*

class DetailMovieActivity : AppCompatActivity(), DetailMovieView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)
        setSupportActionBar(toolbar)

    }

    override fun detailMovie() {

    }

    override fun successDetailMovie(detailMovie: DetailMovie) {

    }

    override fun error() {

    }

    override fun createPresenter() {

    }
}
