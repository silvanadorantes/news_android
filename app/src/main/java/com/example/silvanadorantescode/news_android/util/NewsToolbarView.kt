package com.example.silvanadorantescode.news_android.util

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import com.example.silvanadorantescode.news_android.R
import com.example.silvanadorantescode.news_android.databinding.ToolbarNewsBinding

/**
 * Created by SilvanaDorantes on 21/04/20.
 */
class NewsToolbarView: LinearLayout {
    var title : String = ""
    lateinit var newsBinding: ToolbarNewsBinding

    constructor(context: Context?) : super(context){
        init(null, context!!)
    }
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs){
        init(attrs, context!!)
    }
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        init(attrs, context!!)
    }


    fun init(@Nullable set: AttributeSet?, context: Context) {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        newsBinding = DataBindingUtil.inflate(inflater, R.layout.toolbar_news, this, true)

        if (context.obtainStyledAttributes(set, R.styleable.NewsToolbarView, 0, 0).getBoolean(R.styleable.NewsToolbarView_menu_toolbar, true)) {
            newsBinding.iconLeft.setImageDrawable(context.resources.getDrawable(R.drawable.ic_menu_white_24dp))
        } else {
            newsBinding.iconLeft.setImageDrawable(context.resources.getDrawable(R.drawable.ic_chevron_left_white_24dp))
        }
        if (context.obtainStyledAttributes(set, R.styleable.NewsToolbarView, 0, 0).getBoolean(R.styleable.NewsToolbarView_icon_left_toolbar, false)) {
            newsBinding.iconLeft.visibility = View.VISIBLE
        } else {
            newsBinding.iconLeft.visibility = View.INVISIBLE
        }



        when (context.obtainStyledAttributes(set, R.styleable.NewsToolbarView, 0, 0).getInt(R.styleable.NewsToolbarView_icon_right_drawable, 0)) {
            0 -> newsBinding.iconRight.setImageDrawable(context.resources.getDrawable(R.drawable.ic_heart_outline_white_24dp))
            1 -> newsBinding.iconRight.setImageDrawable(context.resources.getDrawable(R.drawable.ic_heart_white_24dp))
            2 -> newsBinding.iconRight.setImageDrawable(context.resources.getDrawable(R.drawable.ic_trash_can_white_24dp))
        }


        if (context.obtainStyledAttributes(set, R.styleable.NewsToolbarView, 0, 0).getBoolean(R.styleable.NewsToolbarView_icon_right_toolbar, false)) {
            newsBinding.iconRight.visibility = View.VISIBLE
        } else {
            newsBinding.iconRight.visibility = View.INVISIBLE
        }
        if (context.obtainStyledAttributes(set, R.styleable.NewsToolbarView, 0, 0).getString(R.styleable.NewsToolbarView_title_toolbar) != null)
            title = context.obtainStyledAttributes(set, R.styleable.NewsToolbarView, 0, 0).getString(R.styleable.NewsToolbarView_title_toolbar) as String
        if (title != null && !title.equals("")) {
            newsBinding.titleHeader.text = title
            newsBinding.titleHeader.visibility = View.VISIBLE

        } else {
            newsBinding.titleHeader.visibility = View.GONE

        }

    }

    fun iconLeftOnClickListener(onClickListener: View.OnClickListener) {
        newsBinding.iconLeft.setOnClickListener(onClickListener)
    }

    fun iconRigthOnClickListener(onClickListener: View.OnClickListener) {
        newsBinding.iconRight.setOnClickListener(onClickListener)
    }
}