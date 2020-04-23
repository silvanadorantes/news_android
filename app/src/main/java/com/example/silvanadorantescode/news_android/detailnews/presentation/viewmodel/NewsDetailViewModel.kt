package com.example.silvanadorantescode.news_android.detailnews.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.example.silvanadorantescode.news_android.app.network.data.news.ArticlesListItem
import com.example.silvanadorantescode.news_android.util.base.BaseViewModel


/**
 * Created by SilvanaDorantes on 21/04/20.
 */

class NewsDetailViewModel: BaseViewModel() {

    var news: MutableLiveData<ArticlesListItem?> = MutableLiveData<ArticlesListItem?>()

    fun bindData(articlesListItem: ArticlesListItem){
        news.value = articlesListItem
    }

    fun getNewsData() : MutableLiveData<ArticlesListItem?>{
        return news
    }

}