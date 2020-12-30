package com.drcarter.daggerandroid.di.module

import com.drcarter.daggerandroid.di.ActivityScope
import com.drcarter.daggerandroid.di.module.submodule.SubFragmentBuilderModule
import com.drcarter.daggerandroid.ui.main.MainActivity
import com.drcarter.daggerandroid.ui.sub.SubActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector(
        modules = [
            SubFragmentBuilderModule::class
        ]
    )
    abstract fun bindSubActivity(): SubActivity
}