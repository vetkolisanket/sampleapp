package com.sanket.sampleapp.utils

import android.util.Log
import com.sanket.sampleapp.BuildConfig
import com.sanket.sampleapp.application.Constants

/**
 * Created by Sanket on 02/05/19.
 */
object Logger {
    private const val TAG = Constants.LOGGER_TAG

    fun logError(message: String) {
        if (BuildConfig.DEBUG)
            Log.e(TAG, message)
    }

    fun logInfo(message: String) {
        if (BuildConfig.DEBUG)
            Log.d(TAG, message)
    }
}