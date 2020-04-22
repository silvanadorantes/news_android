package com.example.silvanadorantescode.news_android.listnews.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.silvanadorantescode.news_android.app.network.data.news.ArticlesListItem
import com.example.silvanadorantescode.news_android.listnews.domain.NewsRepositoryImpl
import com.example.silvanadorantescode.news_android.util.base.BaseViewModel
import com.google.android.material.tabs.TabLayout
import javax.inject.Inject


/**
 * Created by SilvanaDorantes on 21/04/20.
 */

class ListNewsViewModel: BaseViewModel() {
    private val TAG = ListNewsViewModel::class.java.simpleName

    @Inject
    lateinit var newsRepositoryImpl: NewsRepositoryImpl

    fun callNew(token: String, country: String){
        newsRepositoryImpl.callListNewsApi(token, country)
    }

    fun getNews(): MutableLiveData<List<ArticlesListItem>>{
        return newsRepositoryImpl.getListArticles()
    }

    fun getListNewsLoading(): MutableLiveData<Boolean>{
        return newsRepositoryImpl.getListNewsLoading()
    }

    fun getListNewsErrorMessage(): MutableLiveData<String>{
        return newsRepositoryImpl.getListNewsErrorMessage()
    }

    fun getListNewsErrorCode(): MutableLiveData<String>{
        return newsRepositoryImpl.getListNewsErrorCode()
    }

}