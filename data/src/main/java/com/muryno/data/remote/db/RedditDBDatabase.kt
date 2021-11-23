package com.muryno.data.remote.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.muryno.data.remote.db.dao.RedditDao
import com.muryno.data.models.RedditKeys
import com.muryno.data.models.RedditPostModel


@Database(
    entities = [RedditKeys::class,RedditPostModel::class],
    version = 4,
    exportSchema = false
)
abstract class RedditDBDatabase : RoomDatabase() {
    abstract fun redditDao(): RedditDao
}