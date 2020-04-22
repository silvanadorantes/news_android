package com.example.silvanadorantescode.news_android.app.network.di

import android.content.Context
import android.os.Build
import com.example.silvanadorantescode.news_android.BuildConfig
import com.example.silvanadorantescode.news_android.app.App
import com.example.silvanadorantescode.news_android.app.di.AppScope
import com.example.silvanadorantescode.news_android.app.network.interceptor.ConnectivityInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import java.io.File
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by SilvanaDorantes on 21/04/20.
 */

@Module
class NetworkModule {
    @Provides
    @AppScope
    fun provideInterceptor(): HttpLoggingInterceptor {

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return interceptor
    }

    @Provides
    @AppScope
    fun provideCache(cacheFile: File): Cache {
        return Cache(cacheFile, 10 * 1000 * 1000) //10MB Cahe
    }


    @Provides
    @AppScope
    fun provideCacheFile(context: Context): File {
        return File(context.getCacheDir(), "okhttp_cache")
    }


    @Provides
    @AppScope
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(ConnectivityInterceptor(App.get()))
            .addInterceptor(object : Interceptor {
                lateinit var request: Request
                override fun intercept(chain: Interceptor.Chain): Response {
                    request = chain!!.request().newBuilder()
                        .addHeader("User-Agent", "News-ANDROID " + " BUILD VERSION: " + BuildConfig.VERSION_NAME + " SMARTPHONE: " + Build.MODEL + " ANDROID VERSION: " + Build.VERSION.RELEASE)
                        .addHeader("Content-Type", "application/json")
                        .addHeader("Language", Locale.getDefault().getLanguage().toUpperCase()  )
                        .build()
                    return chain.proceed(request)
                }

            })
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .cache(cache)
            .build()
    }
}