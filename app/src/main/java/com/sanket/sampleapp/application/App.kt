package com.sanket.sampleapp.application

import Injection
import android.app.Activity
import android.app.Application

/**
 * Created by Sanket on 02/05/19.
 */
class App: Application() {

    fun App.getSharedPreferences() = getSharedPreferences(Injection.PREFERENCE_FILE_NAME, Activity.MODE_PRIVATE)

    override fun onCreate() {
        super.onCreate()

    }

}