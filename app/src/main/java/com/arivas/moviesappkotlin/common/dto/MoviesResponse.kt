package com.arivas.moviesappkotlin.common.dto

import com.google.gson.annotations.SerializedName

data class MoviesResponse(@SerializedName("page")
                          val page: Int = 0,
                          @SerializedName("total_pages")
                          val totalPages: Int = 0,
                          @SerializedName("results")
                          val results: List<ResultsItem>?,
                          @SerializedName("total_results")
                          val totalResults: Int = 0)