package com.sanket.sampleapp.robots

import androidx.test.core.app.ApplicationProvider
import androidx.test.rule.ActivityTestRule
import com.sanket.sampleapp.R
import com.sanket.sampleapp.base.Espresso
import com.sanket.sampleapp.features.onboarding.ui.activities.LoginActivity
import com.sanket.sampleapp.features.onboarding.ui.activities.OnboardingActivity
import com.sanket.sampleapp.features.onboarding.ui.activities.SignUpActivity

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

    fun isSignUpBtnVisible(): OnboardingRobot {
        Espresso.isViewVisible(R.id.btnSignup)
        return this
    }

    fun clickSignUpBtn(): OnboardingRobot {
        Espresso.performClick(R.id.btnSignup)
        return this
    }

    fun isSignUpActivityOpen() {
        Espresso.isActivityOpen(SignUpActivity::class.java.name)
    }
}