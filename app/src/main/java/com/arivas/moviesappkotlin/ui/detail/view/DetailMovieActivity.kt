package com.arivas.moviesappkotlin.ui.detail.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import android.widget.Toolbar
import com.arivas.moviesappkotlin.BuildConfig
import com.arivas.moviesappkotlin.R
import com.arivas.moviesappkotlin.common.dto.DetailMovie
import com.arivas.moviesappkotlin.common.network.RetrofitService
import com.arivas.moviesappkotlin.ui.detail.presenter.DetailMoviePresenter
import com.arivas.moviesappkotlin.ui.detail.presenter.DetailMoviePresenterImpl
import com.facebook.drawee.view.SimpleDraweeView
import kotlinx.android.synthetic.main.activity_detail_movie.*
import org.koin.android.ext.android.inject

class DetailMovieActivity : AppCompatActivity(), DetailMovieView {
    private var presenter: DetailMoviePresenter? = null
    private var overview: TextView? = null
    private var imgDetail: SimpleDraweeView? = null
    private val service: RetrofitService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        overview = findViewById(R.id.overview)
        imgDetail = findViewById(R.id.image_detail)

        createPresenter()
        detailMovie()
    }

    override fun detailMovie() {
        val movieId = intent.getIntExtra("movieId",0)
        presenter?.detailMovie(movieId)
    }

    override fun successDetailMovie(detailMovie: DetailMovie) {
        toolbar_detail.title = detailMovie.title
        overview?.text = detailMovie.overview
        imgDetail?.setImageURI(BuildConfig.BASE_URL_IMAGES + detailMovie.backdropPath)
    }

    override fun error() {

    }

    override fun createPresenter() {
        presenter = DetailMoviePresenterImpl(this, service)
    }
}
