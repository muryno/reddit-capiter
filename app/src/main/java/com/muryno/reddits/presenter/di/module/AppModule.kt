package com.muryno.reddits.presenter.di.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    @Named("application.Context")
    fun provideContext(application: Application) : Context {
        return application.applicationContext
    }
    @Provides
    @Singleton
    @Named("application")
    fun provideApplication(application: Application) : Application {
        return application
    }
}