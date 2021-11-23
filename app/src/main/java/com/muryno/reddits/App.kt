package com.muryno.reddits

import android.app.Application
import com.muryno.reddits.presenter.di.DaggerRedisComponent
import com.muryno.reddits.presenter.di.RedisComponent
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors


open class App : Application() {
    lateinit var appComponent: RedisComponent
    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerRedisComponent
            .builder()
            .application(this)
            .context(this)
            .build()
        appComponent.inject(this)

    }

    companion object {
        val executorService: ExecutorService =
            Executors.newCachedThreadPool()

        var instance: App? = null
            private set
    }


}