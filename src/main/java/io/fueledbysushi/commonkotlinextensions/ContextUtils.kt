package io.fueledbysushi.commonkotlinextensions

import android.app.Activity
import android.content.Context
import android.os.Build
import android.util.DisplayMetrics
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

/**
 * Created by Johndale Alfred Julian on 10/31/2018. All Rights Reserved.
 */

/**
 * Shows a short @see Toast
 */
fun Context.showToast(text: String): Toast {
    return Toast.makeText(this, text, Toast.LENGTH_SHORT).also { it.show() }
}

/**
 * Shows a long @see Toast
 */
fun Context.showToastLong(text: String): Toast {
    return Toast.makeText(this, text, Toast.LENGTH_LONG).also { it.show() }
}

/**
 * Hides soft keyboard
 */
fun Activity.hideKeyboard() {
    val view = this.currentFocus
    val methodManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    assert(view != null)
    methodManager.hideSoftInputFromWindow(view!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
}

/**
 * Shows soft keyboard
 */
fun Activity.showKeyboard() {
    val view = this.currentFocus
    val methodManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    assert(view != null)
    methodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
}

/**
 * Logs error with the context name as its TAG
 */
fun Context.logError(message: String) {
    Log.e(this::class.java.simpleName, message)
}

/**
 * Logs info with the context name as its TAG
 */
fun Context.logInfo(message: String) {
    Log.i(this::class.java.simpleName, message)
}

/**
 * Logs warning with the Context name as its TAG
 */
fun Context.logWarning(message: String) {
    Log.w(this::class.java.simpleName, message)
}

/**
 * Returns the complete device and app details
 */
fun getDeviceDetails(): String {
    return StringBuilder().apply {
        append("OS = " + System.getProperty("os.version") + "; ")
        append("SDK_INT = " + Build.VERSION.SDK_INT + "; ")
        append("BUILD_DEVICE = " + Build.DEVICE + "; ")
        append("BUILD_RELEASE = Android " + Build.VERSION.RELEASE + "; ")
        append("BUILD_MODEL = " + Build.MODEL + "; ")
        append("APPLICATION_ID = " + BuildConfig.APPLICATION_ID + "; ")
        append("BUILD_MANUFACTURER = " + Build.MANUFACTURER + "; ")
        append("Version Name = " + BuildConfig.VERSION_NAME)
    }.toString()
}

/**
 * Returns the screen density
 * Example: ldpi, mdpi, ...
 */
fun Context.getScreenDensity(): String {
    return when (resources.displayMetrics.densityDpi) {
        DisplayMetrics.DENSITY_LOW -> "ldpi"
        DisplayMetrics.DENSITY_MEDIUM -> "mdpi"
        DisplayMetrics.DENSITY_HIGH -> "hdpi"
        DisplayMetrics.DENSITY_XHIGH, DisplayMetrics.DENSITY_280 -> "xhdpi"
        DisplayMetrics.DENSITY_XXHIGH, DisplayMetrics.DENSITY_360, DisplayMetrics.DENSITY_400, DisplayMetrics.DENSITY_420 -> "xxhdpi"
        DisplayMetrics.DENSITY_XXXHIGH, DisplayMetrics.DENSITY_560 -> "xxxhdpi"
        else -> "Unknown code ${resources.displayMetrics.densityDpi}"
    }
}

