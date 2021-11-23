package com.muryno.reddits.presenter.utils


import android.view.View
import android.widget.Toast
import com.muryno.reddits.App


fun showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(App.instance?.applicationContext, message, duration).show()
}
