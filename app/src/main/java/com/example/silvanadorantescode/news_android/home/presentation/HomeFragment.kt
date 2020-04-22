package com.example.silvanadorantescode.news_android.home.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.silvanadorantescode.news_android.R
import com.example.silvanadorantescode.news_android.databinding.FragmentHomeBinding
import com.example.silvanadorantescode.news_android.home.presentation.adapter.NewsHomePagerAdapter
import com.example.silvanadorantescode.news_android.util.Constant
import com.example.silvanadorantescode.news_android.util.base.BaseFragment
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.IndexOutOfBoundsException


/**
 * Created by SilvanaDorantes on 21/04/20.
 */
class HomeFragment: Fragment() {

    lateinit var homeBinding: FragmentHomeBinding

    companion object{
        val TAG = HomeFragment::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)
        val tabLayout = homeBinding.tabs
        val viewPager =  homeBinding.viewPager
        viewPager.adapter = NewsHomePagerAdapter(this)
        TabLayoutMediator(tabLayout, viewPager) {tab, position ->  
            tab.text = getTabTitle(position)
        }.attach()

        (activity as AppCompatActivity).setSupportActionBar(homeBinding.toolbar)
        return homeBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun getTabTitle(position:Int): String? {
        return when(position){
            Constant.LIST_NEWS_FRAGMENT_INDEX -> getString(R.string.news)
            Constant.LIST_FAVORITE_NEWS_FRAGMENT_INDEX -> getString(R.string.favorite_news)
            else -> null

        }
    }
}