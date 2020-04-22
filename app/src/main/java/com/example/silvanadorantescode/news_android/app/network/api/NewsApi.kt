package com.example.silvanadorantescode.news_android.app.network.api

import com.example.silvanadorantescode.news_android.app.network.data.news.ArticlesListItemResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Created by SilvanaDorantes on 21/04/20.
 */

interface NewsApi {

    @GET("top-headlines")
    fun getListNews(@Header("X-Api-Key") token: String,
                    @Query("country") country: String
    ): Call<ArticlesListItemResponse>
}