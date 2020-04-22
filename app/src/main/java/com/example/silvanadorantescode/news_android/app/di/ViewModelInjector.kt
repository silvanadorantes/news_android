package com.example.silvanadorantescode.news_android.app.di

import com.example.silvanadorantescode.news_android.app.network.di.RepositoryModule
import com.example.silvanadorantescode.news_android.detailnews.presentation.viewmodel.NewsDetailViewModel
import com.example.silvanadorantescode.news_android.listfavoritenews.presentation.viewmodel.NewsFavoriteViewModel
import com.example.silvanadorantescode.news_android.listnews.presentation.viewmodel.ListNewsViewModel
import dagger.Component

/**
 * Created by SilvanaDorantes on 21/04/20.
 */

@ViewModelScope
@Component(dependencies = [AppComponent::class], modules = [RepositoryModule::class])
interface ViewModelInjector {

    fun inject(listNewsViewModel: ListNewsViewModel)
    fun inject(newsFavoriteViewModel: NewsFavoriteViewModel)
    fun inject(newsDetailViewModel: NewsDetailViewModel)

    @Component.Builder
    interface Builder{
        fun build(): ViewModelInjector
        fun appComponent(appComponent: AppComponent): Builder
    }
}