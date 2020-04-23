package com.example.silvanadorantescode.news_android.listnews.presentation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.silvanadorantescode.news_android.R
import com.example.silvanadorantescode.news_android.app.network.data.news.ArticlesListItem
import com.example.silvanadorantescode.news_android.databinding.FragmentListNewsBinding
import com.example.silvanadorantescode.news_android.listnews.presentation.adapter.NewsAdapter
import com.example.silvanadorantescode.news_android.listnews.presentation.viewmodel.ListNewsViewModel
import com.example.silvanadorantescode.news_android.util.Constant
import com.example.silvanadorantescode.news_android.util.base.BaseFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_list_news.*
import javax.inject.Inject


/**
 * Created by SilvanaDorantes on 21/04/20.
 */

class ListNewsFragment : Fragment() {

    lateinit var listNewsBinding: FragmentListNewsBinding

    @Inject
    lateinit var listNewsViewModel: ListNewsViewModel

    companion object{
        val TAG = ListNewsFragment::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        listNewsViewModel = ViewModelProviders.of(this).get(ListNewsViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        listNewsBinding = FragmentListNewsBinding.inflate(inflater, container, false)
        context ?: return listNewsBinding.root

        return listNewsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val  adapter = NewsAdapter()
        listNewsBinding.recyclerNews.adapter = adapter
        Log.d(TAG, "adapter" + " " + adapter)
        subscribeUi(adapter, listNewsBinding)
        adapter.notifyDataSetChanged()

    }

    private fun subscribeUi(adapter: NewsAdapter, listNewsBinding: FragmentListNewsBinding){
        Log.d(TAG, "CallNews")
        listNewsViewModel.callNew(Constant.TOKEN, Constant.COUNTRY)

        Log.d(TAG, "getListNews - ListNews")
        listNewsViewModel.getNews().observe(viewLifecycleOwner, Observer {
            listArcticles : List<ArticlesListItem> ->
            Log.d(TAG, "listNewsSize" + " " + listArcticles.size)
            Log.d(TAG, "listNews" + " " + listArcticles)
            adapter.submitList(listArcticles)
            Log.d(TAG, "listNewsSize" + " " + listArcticles.size)
            Log.d(TAG, "listNews" + " " + listArcticles)
        })

        listNewsViewModel.getListNewsLoading().observe(viewLifecycleOwner, Observer {
            isLoading: Boolean ->
            isLoading.let {
                progressbar.visibility = if (it) View.VISIBLE else View.GONE
            }
        })

        listNewsViewModel.getListNewsErrorMessage().observe(viewLifecycleOwner, Observer {
            Snackbar.make(listNewsBinding.root, it, Snackbar.LENGTH_LONG).show()
        })

        listNewsViewModel.getListNewsErrorCode().observe(viewLifecycleOwner, Observer {
            Snackbar.make(listNewsBinding.root, it, Snackbar.LENGTH_LONG).show()
        })


    }
}
