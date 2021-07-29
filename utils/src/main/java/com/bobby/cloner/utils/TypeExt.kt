package com.bobby.cloner.utils

/**
 * Created by Bobby Irawan on 29/07/21.
 */

fun Double?.orZero() = this ?: 0.0

fun Boolean?.orFalse() = this ?: false

fun Int?.orZero() = this ?: 0
