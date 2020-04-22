package com.example.silvanadorantescode.news_android.app

import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.util.Base64
import android.util.Log
import androidx.multidex.MultiDex
import com.example.silvanadorantescode.news_android.app.di.*
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

/**
 * Created by SilvanaDorantes on 21/04/20.
 */
class App: Application() {

    lateinit var component: AppComponent
    private val viewModelInjector : ViewModelInjector by lazy {
        DaggerViewModelInjector.builder().appComponent(component).build()
    }


    companion object{
        @JvmStatic
        lateinit var INSTANCE: App



        @JvmStatic
        fun get(): App {
            return INSTANCE
        }

        @JvmStatic
        fun getAppContext(): Context {
            return INSTANCE.getBaseContext()
        }

    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        turnOnStrictMode()
        initComponent()
        getInjector()



        try {
            val info = packageManager.getPackageInfo(
                "com.example.silvanadorantescode.news_android",
                PackageManager.GET_SIGNATURES)
            for (signature in info.signatures) {
                val md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.d("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT))
            }
        } catch (e: PackageManager.NameNotFoundException) {
        } catch (e: NoSuchAlgorithmException) {
        }
    }

    private fun turnOnStrictMode() {

    }

    fun initComponent() {
        component = DaggerAppComponent.builder()
            .appModule(AppModule(INSTANCE)).build()

    }

    fun getInjector(): ViewModelInjector = viewModelInjector



    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    fun component(): AppComponent {
        return component
    }



}