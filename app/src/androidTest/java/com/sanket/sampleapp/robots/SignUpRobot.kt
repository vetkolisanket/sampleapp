package com.sanket.sampleapp.robots

import androidx.test.core.app.ApplicationProvider
import androidx.test.rule.ActivityTestRule
import com.sanket.sampleapp.R
import com.sanket.sampleapp.application.App
import com.sanket.sampleapp.base.Espresso
import com.sanket.sampleapp.features.home.ui.activities.HomeActivity
import com.sanket.sampleapp.features.onboarding.ui.activities.SignUpActivity

/**
 * Created by Sanket on 13/05/19.
 */
class SignUpRobot {
    fun launch(rule: ActivityTestRule<SignUpActivity>): SignUpRobot {
        rule.launchActivity(SignUpActivity.newIntent(ApplicationProvider.getApplicationContext()))
        return this
    }

    fun enterName(name: String): SignUpRobot {
        Espresso.enterText(R.id.tietFullName, name)
        return this
    }

    fun enterEmail(email: String): SignUpRobot {
        Espresso.enterText(R.id.tietEmail, email)
        return this
    }

    fun enterMobile(mobile: String): SignUpRobot {
        Espresso.enterText(R.id.tietMobile, mobile)
        return this
    }

    fun enterPassword(password: String): SignUpRobot {
        Espresso.enterText(R.id.tietPassword, password)
        return this
    }

    fun clickDone(): SignUpRobot {
        Espresso.performClick(R.id.btnDone)
        return this
    }

    fun sendMockSuccessResponse(rule: ActivityTestRule<SignUpActivity>): SignUpRobot {
        rule.activity.runOnUiThread { rule.activity.onSignUpSuccess() }
        return this
    }

    fun verifyHomeActivityIsOpen() {
        Espresso.isActivityOpen(HomeActivity::class.java.name)
    }

    fun verifyErrorIsShownInNameEditText() {
        val errorMessage = ApplicationProvider.getApplicationContext<App>().getString(R.string.error_full_name_empty)
        Espresso.isErrorShownInEditText(R.id.tietFullName, errorMessage)
    }

    fun verifyPasswordInvalidErrorIsShown() {
        val errorMessage = ApplicationProvider.getApplicationContext<App>().getString(R.string.error_password_invalid)
        Espresso.isErrorShownInEditText(R.id.tietPassword, errorMessage)
    }

    fun verifyPasswordEmptyErrorIsShown() {
        val errorMessage = ApplicationProvider.getApplicationContext<App>().getString(R.string.error_password_empty)
        Espresso.isErrorShownInEditText(R.id.tietPassword, errorMessage)
    }

    fun verifyMobileNoEmptyErrorIsShown() {
        val errorMessage = ApplicationProvider.getApplicationContext<App>().getString(R.string.error_mobile_no_invalid)
        Espresso.isErrorShownInEditText(R.id.tietMobile, errorMessage)
    }

    fun verifyEmailEmptyErrorIsShown() {
        val errorMessage = ApplicationProvider.getApplicationContext<App>().getString(R.string.error_email_empty)
        Espresso.isErrorShownInEditText(R.id.tietEmail, errorMessage)
    }
}