package com.example.kotlin

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

fun Context.showToastLong(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun Context.showToastLong(message: Int) {
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}

fun setVisibility(view: View, visible: Int) {
    view.visibility=visible
}