package com.example.silvanadorantescode.news_android.util.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.silvanadorantescode.news_android.R
import com.example.silvanadorantescode.news_android.util.NewsToolbarView

/**
 * Created by SilvanaDorantes on 21/04/20.
 */
abstract open class BaseFragment: Fragment() {
    lateinit var toolbar: NewsToolbarView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbar = view.findViewById<View>(R.id.news_toolbar) as NewsToolbarView

    }

}