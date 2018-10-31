package io.fueledbysushi.commonkotlinextensions

import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import java.util.*

/**
 * Created by Johndale Alfred Julian on 10/31/2018. All Rights Reserved.
 */

/**
 * Returns all Views of Type <T> and performs an action on each view
 */
inline fun <reified T : View> ViewGroup.allViewsOfType(action: (T) -> Unit) {
    val views = Stack<View>()

    views.addAll((0 until childCount).map(this::getChildAt))

    while (!views.isEmpty()) {
        views.pop().let {
            if (it is T) action(it)
            if (it is ViewGroup) {
                views.addAll((0 until childCount).map(this::getChildAt))
            }
        }
    }
}

/**
 * Animate a @see View using fade-in animation
 */
fun View.fadeIn() {
    startAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_in))
    visibility = View.VISIBLE
}

/**
 * Animate a @see View using fade-out animation but
 * the view still takes pixel space
 */
fun View.fadeOut() {
    startAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_out))
    visibility = View.INVISIBLE
}

/**
 * Animate a @see View using fade-out animation,
 * the @see View won't take any pixel space
 */
fun View.fadeOutGone() {
    startAnimation(AnimationUtils.loadAnimation(context, android.R.anim.fade_out))
    visibility = View.GONE
}