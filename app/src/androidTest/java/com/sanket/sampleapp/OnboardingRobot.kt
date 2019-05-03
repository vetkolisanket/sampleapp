package com.sanket.sampleapp

import androidx.test.core.app.ApplicationProvider
import androidx.test.rule.ActivityTestRule
import com.sanket.sampleapp.features.onboarding.ui.OnboardingActivity

/**
 * Created by Sanket on 02/05/19.
 */
class OnboardingRobot {

    fun launch(rule: ActivityTestRule<OnboardingActivity>): OnboardingRobot {
        rule.launchActivity(OnboardingActivity.newIntent(ApplicationProvider.getApplicationContext()))
        return this
    }

}