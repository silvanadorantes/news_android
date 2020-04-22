package com.example.silvanadorantescode.news_android.listnews.domain

import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.silvanadorantescode.news_android.R
import com.example.silvanadorantescode.news_android.app.network.NetWorkCallback
import com.example.silvanadorantescode.news_android.app.network.api.NewsApi
import com.example.silvanadorantescode.news_android.app.network.data.news.ArticlesListItem
import com.example.silvanadorantescode.news_android.app.network.data.news.ArticlesListItemResponse
import com.example.silvanadorantescode.news_android.util.Commons

/**
 * Created by SilvanaDorantes on 21/04/20.
 */

class NewsRepositoryImpl(var newsApi: NewsApi) {
    val TAG = NewsRepositoryImpl::class.java.simpleName
    private  var articlesList = MutableLiveData<List<ArticlesListItem>>()
    private var loading = MutableLiveData<Boolean>()
    private var error = MutableLiveData<String>()
    private var errorFail = MutableLiveData<String>()

    fun getListArticles(): MutableLiveData<List<ArticlesListItem>>{
        return articlesList
    }

    fun getListNewsLoading(): MutableLiveData<Boolean>{
        return loading
    }

    fun getListNewsErrorMessage(): MutableLiveData<String>{
        return error
    }

    fun getListNewsErrorCode(): MutableLiveData<String>{
        return errorFail
    }

    fun callListNewsApi(token: String, country: String){
        var listArticles: ArrayList<ArticlesListItem>? = ArrayList<ArticlesListItem>()
        loading.value = true
        newsApi.getListNews(token, country).enqueue(object : NetWorkCallback<ArticlesListItemResponse>(){

            override fun onRequestSuccess(response: ArticlesListItemResponse) {
                Log.d(TAG, "ArticlesNewsOk")
                listArticles?.addAll(response.articles)
                articlesList.value = listArticles
                loading.value = false

            }

            override fun onRequestFail(errorMessage: String) {
                Log.d(TAG, "FailResponse")
                loading.value = false
                error.value = errorMessage

            }

            override fun onRequestFail(errorCode: Int) {
                Log.d(TAG, "FailResponse")
                if (errorCode == NetWorkCallback.NO_HAVE_INTERNET){
                    Log.d(TAG,"NO HAVE INTERNET")
                    loading.value = false
                    errorFail.value = Commons.getString(R.string.no_internet)
                }

                if (errorCode == NetWorkCallback.ERROR_CONNECTION){
                    Log.d(TAG,"Error CONNECTION")
                    loading.value = false
                    errorFail.value = Commons.getString(R.string.network_error)
                }
            }
        })
    }


}