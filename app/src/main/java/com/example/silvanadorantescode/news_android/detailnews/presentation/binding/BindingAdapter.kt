package com.example.silvanadorantescode.news_android.detailnews.presentation.binding

import android.webkit.WebView
import androidx.databinding.BindingAdapter


/**
 * Created by SilvanaDorantes on 21/04/20.
 */

@BindingAdapter("loadUrl")
fun WebView.setUrl(url: String) {
    this.loadUrl(url)
}