package com.drcarter.daggerandroid.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.drcarter.daggerandroid.di.ViewModelBindingFactory
import com.drcarter.daggerandroid.di.ViewModelKey
import com.drcarter.daggerandroid.ui.main.MainViewModel
import com.drcarter.daggerandroid.ui.sub.fragment.SubViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelBindingFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SubViewModel::class)
    abstract fun bindSubViewModel(viewModel: SubViewModel): ViewModel
}