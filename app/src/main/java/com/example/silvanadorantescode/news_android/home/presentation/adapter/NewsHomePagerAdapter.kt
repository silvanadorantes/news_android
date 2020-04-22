package com.example.silvanadorantescode.news_android.home.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.silvanadorantescode.news_android.listfavoritenews.presentation.ListFavoriteNewsFragment
import com.example.silvanadorantescode.news_android.listnews.presentation.ListNewsFragment
import com.example.silvanadorantescode.news_android.util.Constant
import java.lang.IndexOutOfBoundsException


/**
 * Created by SilvanaDorantes on 22/04/20.
 */
class NewsHomePagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    private val tabFragmentsCreators: Map<Int, () -> Fragment> = mapOf(
        Constant.LIST_NEWS_FRAGMENT_INDEX to {ListNewsFragment()},
        Constant.LIST_FAVORITE_NEWS_FRAGMENT_INDEX to  {ListFavoriteNewsFragment()}
    )


    override fun getItemCount() = tabFragmentsCreators.size

    override fun createFragment(position: Int): Fragment {
        return tabFragmentsCreators[position]?.invoke() ?: throw IndexOutOfBoundsException()
    }
}