package com.bobby.cloner.utils

import android.view.View

fun View.setVisible() {
    visibility = View.VISIBLE
}

fun View.setGone() {
    visibility = View.GONE
}

fun View.showIf(condition: Boolean) {
    if (condition) this.setVisible() else this.setGone()
}
