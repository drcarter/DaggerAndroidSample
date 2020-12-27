package com.drcarter.daggerandroid.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class AppApplication

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class ApplicationContext
