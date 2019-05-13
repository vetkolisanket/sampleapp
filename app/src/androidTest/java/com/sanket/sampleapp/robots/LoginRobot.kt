package com.sanket.sampleapp.robots

import androidx.test.core.app.ApplicationProvider
import androidx.test.rule.ActivityTestRule
import com.sanket.sampleapp.R
import com.sanket.sampleapp.base.Espresso
import com.sanket.sampleapp.features.home.ui.activities.HomeActivity
import com.sanket.sampleapp.features.onboarding.ui.activities.LoginActivity

/**
 * Created by Sanket on 04/05/19.
 */
class LoginRobot {
    fun launch(rule: ActivityTestRule<LoginActivity>): LoginRobot {
        rule.launchActivity(LoginActivity.newIntent(ApplicationProvider.getApplicationContext()))
        return this
    }

    fun isLoginBtnVisible(): LoginRobot {
        Espresso.isViewVisible(R.id.btnLogin)
        return this
    }

    fun clickLoginBtn(): LoginRobot {
        Espresso.performClick(R.id.btnLogin)
        return this
    }

    fun isErrorShown(errorMessage: String) {
        Espresso.isToastVisibleWithMessage(errorMessage)
    }

    fun sendMockFailureResponse(
        rule: ActivityTestRule<LoginActivity>,
        errorMessage: String
    ): LoginRobot {
        rule.activity.runOnUiThread {
            rule.activity.showMessage(errorMessage)
        }
        return this
    }

    fun isEmailFieldVisible(): LoginRobot {
        Espresso.isViewVisible(R.id.tietEmail)
        return this
    }

    fun enterEmail(email: String): LoginRobot {
        Espresso.enterText(R.id.tietEmail, email)
        return this
    }

    fun isPasswordFieldVisible(): LoginRobot {
        Espresso.isViewVisible(R.id.tietPassword)
        return this
    }

    fun enterPassword(password: String): LoginRobot {
        Espresso.enterText(R.id.tietPassword, password)
        return this
    }

    fun sendMockSuccessResponse(rule: ActivityTestRule<LoginActivity>): LoginRobot {
        rule.activity.run {
            rule.activity.onLoginSuccess()
        }
        return this
    }

    fun isHomeActivityOpen() {
        Espresso.isActivityOpen(HomeActivity::class.java.name)
    }
}