package com.rahimliahmad.exam_23_05.Api

import com.rahimliahmad.exam_23_05.model.*
import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("search/movie")
    fun getMovies():Call<List<Movies>>

    @GET("movie/popular")
    fun getPopMovie():Call<Results>


    @GET("genre/movie/list")
    fun getGenre():Call<Genres>

    @GET("/movie/550")
    fun getDetail():Call<List<Detail>>





}