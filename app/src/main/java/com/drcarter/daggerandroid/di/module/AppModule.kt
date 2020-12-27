package com.drcarter.daggerandroid.di.module

import android.app.Application
import android.content.Context
import com.drcarter.daggerandroid.MainApplication
import com.drcarter.daggerandroid.di.AppApplication
import com.drcarter.daggerandroid.di.ApplicationContext
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @AppApplication
    @Singleton
    @Provides
    fun getApplication(application: MainApplication): Application = application


    @ApplicationContext
    @Singleton
    @Provides
    fun getApplicationContext(application: MainApplication): Context = application.applicationContext
}
