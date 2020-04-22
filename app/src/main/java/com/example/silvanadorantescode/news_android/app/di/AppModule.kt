package com.example.silvanadorantescode.news_android.app.di

import android.content.Context
import android.content.res.Resources
import com.example.silvanadorantescode.news_android.app.App
import dagger.Module
import dagger.Provides

/**
 * Created by SilvanaDorantes on 21/04/20.
 */

@Module
class AppModule(val app: App){

    @Provides
    @AppScope
    fun provideApp(): App {
        return app
    }

    @Provides
    @AppScope
    fun provideResources(): Resources {
        return app.getResources()
    }

    @Provides
    @AppScope
    fun provideApplicationContext(): Context {
        return app
    }

    @Provides
    @AppScope
    fun provideAppComponent(appComponent: AppComponent): AppComponent {
        return appComponent
    }
}