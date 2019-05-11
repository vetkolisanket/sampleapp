package com.sanket.sampleapp.application

import Injection
import android.app.Activity
import android.app.Application
import android.content.Context

/**
 * Created by Sanket on 02/05/19.
 */
class App: Application() {

    companion object {
        // TODO: 11/05/19 How do I do this without causing a memory leak ?
        lateinit var context: Context

        fun getPreferences() = context.getSharedPreferences(Injection.PREFERENCE_FILE_NAME, Activity.MODE_PRIVATE)
    }

    override fun onCreate() {
        super.onCreate()

        App.context = applicationContext
    }

}