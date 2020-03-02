package com.ferdyrod.viewpagersample

import android.content.res.Configuration
import android.content.res.Resources

fun isPortrait(): Boolean {
    val orientation = Resources.getSystem().configuration.orientation
    return orientation == Configuration.ORIENTATION_PORTRAIT
}