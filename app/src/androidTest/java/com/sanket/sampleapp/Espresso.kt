package com.sanket.sampleapp

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId

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
}