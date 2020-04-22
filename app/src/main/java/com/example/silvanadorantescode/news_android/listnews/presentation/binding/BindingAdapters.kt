package com.example.silvanadorantescode.news_android.listnews.presentation.binding

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.silvanadorantescode.news_android.R
import com.example.silvanadorantescode.news_android.util.Commons


/**
 * Created by SilvanaDorantes on 21/04/20.
 */


@BindingAdapter("visible")
fun View.bindVisible(visible: Boolean?) {
    visibility = if (visible == true) View.VISIBLE else View.GONE
}

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter("imageUrl")
fun getImageNews(imgNews: ImageView, imageUrl: String ){
    Commons.loadImageGlide(imageUrl, imgNews, R.drawable.ic_news_3, R.drawable.ic_news_3)
}

@BindingAdapter("textDate")
fun getDateNews(dateNews: TextView, publishedAt: String?){
    if (publishedAt != null){
        dateNews.text = Commons.getStringDateOne(publishedAt)

    } else{
        dateNews.text = ""
    }

}
