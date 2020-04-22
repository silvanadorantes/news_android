package com.example.silvanadorantescode.news_android.util.base

import androidx.lifecycle.ViewModel
import com.example.silvanadorantescode.news_android.app.App
import com.example.silvanadorantescode.news_android.detailnews.presentation.viewmodel.NewsDetailViewModel
import com.example.silvanadorantescode.news_android.listfavoritenews.presentation.viewmodel.NewsFavoriteViewModel
import com.example.silvanadorantescode.news_android.listnews.presentation.viewmodel.ListNewsViewModel

/**
 * Created by SilvanaDorantes on 21/04/20.
 */

abstract class BaseViewModel: ViewModel() {

    private val injector = App.get().getInjector()

    init {
        inject()
    }

    private fun inject(){
        when(this){
            is ListNewsViewModel -> injector.inject(this)
            is NewsFavoriteViewModel -> injector.inject(this)
            is NewsDetailViewModel -> injector.inject(this)
        }

    }
}