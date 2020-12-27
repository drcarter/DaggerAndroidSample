package com.drcarter.daggerandroid.di.module

import com.drcarter.daggerandroid.di.ActivityScope
import com.drcarter.daggerandroid.ui.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

}