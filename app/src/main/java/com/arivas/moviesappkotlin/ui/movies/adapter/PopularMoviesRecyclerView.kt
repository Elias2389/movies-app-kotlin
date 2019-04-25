package com.arivas.moviesappkotlin.ui.movies.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.arivas.moviesappkotlin.BuildConfig
import com.arivas.moviesappkotlin.R
import com.arivas.moviesappkotlin.common.dto.ResultsItem
import com.arivas.moviesappkotlin.ui.detail.view.DetailMovieActivity
import com.facebook.drawee.view.SimpleDraweeView

class PopularMoviesRecyclerView(private val results: List<ResultsItem>): RecyclerView.Adapter<PopularMoviesRecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(
            R.layout.card_item,
            p0, false
        )
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return results.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.title.text = results.get(i).title
        viewHolder.img.setImageURI(BuildConfig.BASE_URL_IMAGES + results.get(i).posterPath)
        viewHolder.content.text = results.get(i).overview

        viewHolder.itemView.setOnClickListener {
            goToDetail(viewHolder.itemView.context, results.get(i))
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: SimpleDraweeView = itemView.findViewById(R.id.image)
        val title: TextView = itemView.findViewById(R.id.title)
        val content: TextView = itemView.findViewById(R.id.content)
    }

    private fun goToDetail(context: Context, results: ResultsItem) {
        val detailIntent = Intent(context, DetailMovieActivity::class.java)
        detailIntent.putExtra("movieId", results.id)
        context.startActivity(detailIntent)
    }
}