package com.sanket.sampleapp

import androidx.test.core.app.ApplicationProvider
import androidx.test.rule.ActivityTestRule
import com.sanket.sampleapp.features.onboarding.ui.activities.LoginActivity
import com.sanket.sampleapp.features.onboarding.ui.activities.OnboardingActivity

/**
 * Created by Sanket on 02/05/19.
 */
class OnboardingRobot {

    fun launch(rule: ActivityTestRule<OnboardingActivity>): OnboardingRobot {
        rule.launchActivity(OnboardingActivity.newIntent(ApplicationProvider.getApplicationContext()))
        return this
    }

    fun isLoginBtnVisible(): OnboardingRobot {
//        R.id.btnLogin.isViewVisible()
        Espresso.isViewVisible(R.id.btnLogin)
        return this
    }

    fun clickOnLoginBtn(): OnboardingRobot {
        Espresso.performClick(R.id.btnLogin)
        return this
    }

    fun isLoginActivityOpen() {
        Espresso.isActivityOpen(LoginActivity::class.java.name)
    }
}