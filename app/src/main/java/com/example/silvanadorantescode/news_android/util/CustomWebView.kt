package com.example.silvanadorantescode.news_android.util

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

/**
 * Created by SilvanaDorantes on 21/04/20.
 */

class CustomWebView: WebView {

    constructor(context: Context?) : super(context){
        initWebView()
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        initWebView()
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        initWebView()
    }

    fun setUrl(url: String?) {
        loadUrl(url!!)
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebView() {
        this.webViewClient = WebViewClient()
        this.settings.javaScriptEnabled = true
        this.settings.domStorageEnabled = true
        this.getSettings().setLoadsImagesAutomatically(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            this.getSettings().setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
        }
    }
}