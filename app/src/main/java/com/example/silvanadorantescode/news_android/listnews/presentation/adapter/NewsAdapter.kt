package com.example.silvanadorantescode.news_android.listnews.presentation.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.silvanadorantescode.news_android.R
import com.example.silvanadorantescode.news_android.app.network.data.news.ArticlesListItem
import com.example.silvanadorantescode.news_android.databinding.ItemListNewsBinding
import com.example.silvanadorantescode.news_android.home.presentation.HomeFragmentDirections


/**
 * Created by SilvanaDorantes on 21/04/20.
 */

class NewsAdapter : ListAdapter<ArticlesListItem, NewsAdapter.NewsViewHolder>(NewsDiffCallback()) {

    companion object{
      private val TAG = NewsAdapter::class.java.simpleName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        return NewsViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_list_news, parent, false))

    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = getItem(position)
        holder.bind(news)

    }

    class NewsViewHolder(private val itemListNewsBinding: ItemListNewsBinding): RecyclerView.ViewHolder(itemListNewsBinding.root){

        init {
            itemListNewsBinding.setClickListener {
                itemListNewsBinding.articleItem?.let {articlesListItem ->
                    navigateToDeatilNews(articlesListItem, it)
                }
            }
        }

        private fun navigateToDeatilNews(articlesListItem: ArticlesListItem, view: View){
            val direction = HomeFragmentDirections.actionHomefragmentToNewsdetailfragment(articlesListItem)
            view.findNavController().navigate(direction)
        }

        fun bind(item: ArticlesListItem){
            itemListNewsBinding.apply {
                articleItem = item
                Log.d(TAG,"news" + " "+ articleItem)
                Log.d(TAG, "item" + " " + item)
                executePendingBindings()
            }
        }



    }

    private class NewsDiffCallback: DiffUtil.ItemCallback<ArticlesListItem>(){
        override fun areItemsTheSame(oldItem: ArticlesListItem, newItem: ArticlesListItem): Boolean {
            return oldItem.source?.name == newItem.source?.name

        }

        override fun areContentsTheSame(oldItem: ArticlesListItem, newItem: ArticlesListItem): Boolean {
            return oldItem == newItem

        }
    }
}