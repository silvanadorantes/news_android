package com.example.silvanadorantescode.news_android.detailnews.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.silvanadorantescode.news_android.R
import com.example.silvanadorantescode.news_android.databinding.FragmentDetailNewsBinding
import com.example.silvanadorantescode.news_android.detailnews.presentation.viewmodel.NewsDetailViewModel
import com.example.silvanadorantescode.news_android.util.base.BaseFragment
import javax.inject.Inject


/**
 * Created by SilvanaDorantes on 21/04/20.
 */

class NewsDetailFragment: BaseFragment() {

    lateinit var newsBinding: FragmentDetailNewsBinding
    private val args: NewsDetailFragmentArgs by navArgs()


    @Inject
    lateinit var newsDetailViewModel: NewsDetailViewModel

    companion object{
        val TAG = NewsDetailFragment::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        newsDetailViewModel = ViewModelProviders.of(this).get(NewsDetailViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        newsBinding = FragmentDetailNewsBinding.inflate(inflater, container, false)
        context ?: return newsBinding.root

        return newsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        newsBinding.newsToolbar.iconLeftOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_newsdetailfragment_to_homefragment)
        })

        newsBinding.newsToolbar.iconRigthOnClickListener(View.OnClickListener {

        })

        Log.d(TAG, "ArgNewsItem" + " " + args)

        newsDetailViewModel.bindData(args.newsItem!!)
        newsBinding.newsViewModel = newsDetailViewModel

    }


}