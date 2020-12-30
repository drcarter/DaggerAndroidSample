package com.drcarter.daggerandroid.di.module.submodule

import com.drcarter.daggerandroid.di.FragmentScope
import com.drcarter.daggerandroid.ui.sub.fragment.SubFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SubFragmentBuilderModule {

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindSubFragment(): SubFragment

}