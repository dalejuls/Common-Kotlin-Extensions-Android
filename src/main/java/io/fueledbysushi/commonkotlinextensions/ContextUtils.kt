package io.fueledbysushi.commonkotlinextensions

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.inputmethod.InputMethodManager
import android.widget.Toast

/**
 * Created by Johndale Alfred Julian on 10/31/2018. All Rights Reserved.
 */
fun Context.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun Context.showToastLong(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_LONG).show()
}

fun Activity.hideKeyboard() {
    val view = this.currentFocus
    val methodManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    assert(view != null)
    methodManager.hideSoftInputFromWindow(view!!.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
}

fun Activity.showKeyboard() {
    val view = this.currentFocus
    val methodManager = this.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    assert(view != null)
    methodManager.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
}

fun Context.logError(message: String) {
    Log.e(this::class.java.simpleName, message)
}

fun Context.logInfo(message: String) {
    Log.i(this::class.java.simpleName, message)
}

fun Activity.logWarning(message: String) {
    Log.w(this::class.java.simpleName, message)
}