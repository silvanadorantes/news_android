package com.example.silvanadorantescode.news_android.app.network.di

import com.example.silvanadorantescode.news_android.app.di.AppScope
import com.example.silvanadorantescode.news_android.app.network.api.NewsApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by SilvanaDorantes on 21/04/20.
 */

@Module(includes = [RetrofitModule::class])
class ApiModule {
    @Provides
    @AppScope
    fun provideNewsApi(retrofit: Retrofit): NewsApi{
        return retrofit.create(NewsApi::class.java)
    }
}