package com.arivas.moviesappkotlin.ui.movies.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.arivas.moviesappkotlin.R
import com.arivas.moviesappkotlin.common.dto.MoviesResponse
import com.arivas.moviesappkotlin.ui.movies.adapter.PopularMoviesRecyclerView
import com.arivas.moviesappkotlin.ui.movies.presenter.MoviesPresenter
import com.arivas.moviesappkotlin.ui.movies.presenter.MoviesPresenterImpl

class MoviesActivity : AppCompatActivity(), MoviesView {
    private var presenter: MoviesPresenter? = null
    private var recyclerView: RecyclerView? = null
    private var mAdapter: RecyclerView.Adapter<*>? = null
    private var layoutManager: RecyclerView.LayoutManager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = MoviesPresenterImpl(this)
        recyclerView = findViewById(R.id.recycler_view)

        popularMovies()
    }

    override fun popularMovies() {
        presenter?.popularMovies()
    }

    override fun successPopularMovies(movies: MoviesResponse) {
        layoutManager = LinearLayoutManager(this)
        recyclerView?.layoutManager = layoutManager

        mAdapter = PopularMoviesRecyclerView(movies.results!!)
        recyclerView?.adapter = mAdapter
    }

    override fun error() {
        
    }
}
