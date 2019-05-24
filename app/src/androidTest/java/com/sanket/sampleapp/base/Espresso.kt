package com.sanket.sampleapp.base

import android.app.Activity
import android.view.View
import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.clearText
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.RootMatchers.withDecorView
import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.hamcrest.Matchers.not

/**
 * Created by Sanket on 04/05/19.
 */
object Espresso {

    fun isViewVisible(@IdRes id: Int) {
        onView(withId(id)).check(matches(isDisplayed()))
    }

    fun performClick(@IdRes id: Int) {
        onView(withId(id)).perform(click())
    }

    fun isActivityOpen(name: String) {
        intended(hasComponent(name))
    }

    fun isToastVisibleWithMessage(activity: Activity, errorMessage: String) {
        onView(withText(errorMessage)).inRoot(withDecorView(not<View>(activity.window.decorView)))
            .check(matches(isDisplayed()))
    }

    fun enterText(@IdRes id: Int, text: String) {
        onView(withId(id)).perform(clearText(), typeText(text))
    }

    fun isErrorShownInEditText(@IdRes id: Int, errorMessage: String) {
        onView(withId(id)).check(matches(hasErrorText(errorMessage)))
    }
}