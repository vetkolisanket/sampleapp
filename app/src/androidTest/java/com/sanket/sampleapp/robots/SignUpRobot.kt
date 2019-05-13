package com.sanket.sampleapp.robots

import androidx.test.core.app.ApplicationProvider
import androidx.test.rule.ActivityTestRule
import com.sanket.sampleapp.features.onboarding.ui.activities.SignUpActivity

/**
 * Created by Sanket on 13/05/19.
 */
class SignUpRobot {
    fun launch(rule: ActivityTestRule<SignUpActivity>): SignUpRobot {
        rule.launchActivity(SignUpActivity.newIntent(ApplicationProvider.getApplicationContext()))
        return this
    }
}