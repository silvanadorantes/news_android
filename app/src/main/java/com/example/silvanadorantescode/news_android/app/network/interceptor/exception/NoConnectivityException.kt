package com.example.silvanadorantescode.news_android.app.network.interceptor.exception

import com.example.silvanadorantescode.news_android.R
import com.example.silvanadorantescode.news_android.util.Commons
import java.io.IOException

/**
 * Created by SilvanaDorantes on 21/04/20.
 */

class NoConnectivityException : IOException() {

    override val message
        get() = Commons.getString(R.string.connectivity_exception)
}