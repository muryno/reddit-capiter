package com.muryno.reddits.presenter.di

import android.app.Application
import android.content.Context
import com.muryno.reddits.presenter.di.module.DatabaseAppModule
import com.muryno.reddits.App
import com.muryno.reddits.presenter.activity.DetailsActivity
import com.muryno.reddits.presenter.activity.MainActivity
import com.muryno.reddits.presenter.di.module.*
import com.muryno.reddits.presenter.fragment.FavouriteFragment
import com.muryno.reddits.presenter.fragment.HomeFragment
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [ AppModule::class,NetWorkModuleDI::class, DatabaseAppModule::class, ViewModelFactory::class, DataModule::class, DomainModule::class])
interface RedisComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(detailsActivity: DetailsActivity)
    fun inject(homeFragment: HomeFragment)
    fun inject(favouriteFragment: FavouriteFragment)
    fun inject( application : App)


    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application : Application): Builder

        @BindsInstance
        fun context(context: Context) : Builder

        fun build(): RedisComponent
    }
}