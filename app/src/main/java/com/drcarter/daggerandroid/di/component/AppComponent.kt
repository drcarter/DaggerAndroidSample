package com.drcarter.daggerandroid.di.component

import android.app.Application
import com.drcarter.daggerandroid.MainApplication
import com.drcarter.daggerandroid.di.module.ActivityBindingModule
import com.drcarter.daggerandroid.di.module.AppModule
import com.drcarter.daggerandroid.di.module.VehicleModule
import com.drcarter.daggerandroid.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        VehicleModule::class,
        ViewModelModule::class,
        ActivityBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<MainApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    override fun inject(ksMain: MainApplication)

}