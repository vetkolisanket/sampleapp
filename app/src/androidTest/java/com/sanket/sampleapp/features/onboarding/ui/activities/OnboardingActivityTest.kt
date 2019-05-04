package com.sanket.sampleapp.features.onboarding.ui.activities

import androidx.test.espresso.intent.Intents
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.sanket.sampleapp.base.BaseInstrumentationTest
import com.sanket.sampleapp.robots.OnboardingRobot
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Sanket on 02/05/19.
 */
@RunWith(AndroidJUnit4::class)
class OnboardingActivityTest : BaseInstrumentationTest() {

    private val rule = ActivityTestRule(OnboardingActivity::class.java, false, false)

    private val robot: OnboardingRobot by lazy { OnboardingRobot() }

    @Before
    override fun setup() {
        super.setup()
//        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun launch_activity() {
        robot.launch(rule)
    }

    @Test
    fun should_open_login_activity_on_click_of_login_btn() {
        Intents.init()

        robot
            .launch(rule)
            .isLoginBtnVisible()
            .clickOnLoginBtn()
            .isLoginActivityOpen()

        Intents.release()
    }

    @Test
    fun should_open_sign_up_activity_on_click_of_sign_up_btn() {
        Intents.init()

        robot
            .launch(rule)
            .isSignUpBtnVisible()
            .clickSignUpBtn()
            .isSignUpActivityOpen()

        Intents.release()
    }

}