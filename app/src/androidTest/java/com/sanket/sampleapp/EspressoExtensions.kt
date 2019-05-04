package com.sanket.sampleapp

import androidx.annotation.IdRes
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId

/**
 * Created by Sanket on 03/05/19.
 */

fun Int.isViewVisible() {
    onView(withId(this)).check(matches(isDisplayed()))
}

fun Espresso.isViewVisible(@IdRes id: Int) {
    onView(withId(id)).check(matches(isDisplayed()))
}