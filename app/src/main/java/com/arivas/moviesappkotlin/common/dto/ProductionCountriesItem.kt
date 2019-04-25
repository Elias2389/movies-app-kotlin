package com.arivas.moviesappkotlin.common.dto

import com.google.gson.annotations.SerializedName

data class ProductionCountriesItem(@SerializedName("iso_3166_1")
                                   val iso: String = "",
                                   @SerializedName("name")
                                   val name: String = "")