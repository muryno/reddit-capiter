package com.muryno.data.di

import android.content.Context
import androidx.room.Room

import com.muryno.data.remote.db.RedditDBDatabase
import com.muryno.data.remote.db.dao.RedditDao
import dagger.Module
import dagger.Provides

import javax.inject.Singleton

@Module
class DatabaseAppModule {


    @Singleton
    @Provides
    fun provideShoppingItemDatabase(context: Context)
     = Room.databaseBuilder(context, RedditDBDatabase::class.java, "redditDb")
        .allowMainThreadQueries()
        .fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideRedditDao(
        database: RedditDBDatabase
    ): RedditDao = database.redditDao()

}

















