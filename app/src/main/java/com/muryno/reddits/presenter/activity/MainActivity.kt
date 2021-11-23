package com.muryno.reddits.presenter.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.muryno.reddits.App
import com.muryno.reddits.R
import com.muryno.reddits.databinding.ActivityMainBinding
import com.muryno.reddits.presenter.di.RedisComponent

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var appComponent: RedisComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent = (applicationContext as App).appComponent
        appComponent.inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val navController = findNavController(R.id.nav_fragment)
        binding?.bottomNavigatinView?.apply {
            setupWithNavController(navController)
        }
    }
}