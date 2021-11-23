package com.muryno.reddits.presenter.utils


import android.content.Context
import android.view.View
import android.widget.Toast
import com.muryno.reddits.App


fun showToast(context: Context, message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(context, message, duration).show()
}
