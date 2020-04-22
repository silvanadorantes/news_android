package com.example.silvanadorantescode.news_android.app.network.di

import com.example.silvanadorantescode.news_android.app.di.ViewModelScope
import com.example.silvanadorantescode.news_android.app.network.api.NewsApi
import com.example.silvanadorantescode.news_android.listnews.domain.NewsRepositoryImpl
import dagger.Module
import dagger.Provides

/**
 * Created by SilvanaDorantes on 21/04/20.
 */

@Module
class RepositoryModule {

    @Provides
    @ViewModelScope
    fun provideNewsRepository(newsApi: NewsApi): NewsRepositoryImpl {
        return NewsRepositoryImpl(
            newsApi
        )
    }
}