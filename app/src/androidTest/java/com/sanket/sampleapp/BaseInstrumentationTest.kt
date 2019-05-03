package com.sanket.sampleapp

import androidx.test.espresso.intent.Intents
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

        @JvmStatic
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
    fun teardown() {
        //Clear shared preferences
        AppCache.clear()
        try {
            Intents.release()
        } catch (e: Exception) {
            Logger.logError(e.localizedMessage)
        }
    }

}