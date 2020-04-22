package com.example.silvanadorantescode.news_android.app.di

import com.example.silvanadorantescode.news_android.app.network.api.NewsApi
import com.example.silvanadorantescode.news_android.app.network.di.ApiModule
import dagger.Component

/**
 * Created by SilvanaDorantes on 21/04/20.
 */

@AppScope
@Component(modules = [AppModule::class, ApiModule::class])
interface AppComponent {
    fun newsApi(): NewsApi
}