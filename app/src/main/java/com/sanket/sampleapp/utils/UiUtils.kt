package com.sanket.sampleapp.utils

import android.view.View

/**
 * Created by Sanket on 25/05/19.
 */
object UiUtils {

    fun showHideViews(show: Boolean, vararg views: View) {
        for (view in views) {
            view.visibility = if (show) View.VISIBLE else View.GONE
        }
    }

}