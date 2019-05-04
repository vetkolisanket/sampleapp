package com.sanket.sampleapp.base

import Injection
import android.app.Activity
import android.content.Context
import androidx.core.content.edit
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.intent.Intents
import com.sanket.sampleapp.BuildConfig
import com.sanket.sampleapp.application.AppCache
import com.sanket.sampleapp.application.Constants
import com.sanket.sampleapp.utils.Logger
import org.junit.After
import org.junit.Before

/**
 * Created by Sanket on 02/05/19.
 */
open class BaseInstrumentationTest {

    companion object {

        private val allowedFlavors = listOf(Constants.BuildType.MOCK)

        fun canProvideRealImpl(): Boolean {
            return allowedFlavors.contains(BuildConfig.FLAVOR)
        }
    }

    @Before
    open fun setup() {
        if (!canProvideRealImpl()) {
            throw IllegalStateException("Instrumentation test should only run in mock flavor")
        }
    }

    @After
    open fun teardown() {
        val sharedPreferences = ApplicationProvider.getApplicationContext<Context>()
            .getSharedPreferences(Injection.PREFERENCE_FILE_NAME, Activity.MODE_PRIVATE)
        sharedPreferences.edit {
            clear()
        }
        AppCache.clear()
        try {
            Intents.release()
        } catch (e: Exception) {
            Logger.logError(e.localizedMessage)
        }
    }

}