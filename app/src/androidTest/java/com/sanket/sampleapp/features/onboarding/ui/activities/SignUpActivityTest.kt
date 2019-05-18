package com.sanket.sampleapp.features.onboarding.ui.activities

import androidx.test.espresso.intent.Intents
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.sanket.sampleapp.application.AppCache
import com.sanket.sampleapp.application.Constants
import com.sanket.sampleapp.base.BaseInstrumentationTest
import com.sanket.sampleapp.features.onboarding.presenters.SignUpPresenter
import com.sanket.sampleapp.robots.SignUpRobot
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Created by Sanket on 12/05/19.
 */
@RunWith(AndroidJUnit4::class)
class SignUpActivityTest: BaseInstrumentationTest() {

    private val rule = ActivityTestRule(SignUpActivity::class.java, false, false)

    private val robot: SignUpRobot by lazy { SignUpRobot() }

    @Mock
    private lateinit var mockPresenter: SignUpPresenter

    @Before
    override fun setup() {
        super.setup()
        MockitoAnnotations.initMocks(this)
        AppCache.put(Constants.MOCK.SIGN_UP_PRESENTER, mockPresenter)
    }

    @Test
    fun launch_activity() {
        robot.launch(rule)
    }

    @Test
    fun should_show_name_empty_error_on_click_of_done_click() {
        AppCache.put(Constants.MOCK.SIGN_UP_PRESENTER, SignUpPresenter())

        robot
            .launch(rule)
            .clickDone()
            .verifyErrorIsShownInNameEditText()
    }

    @Test
    fun should_show_email_empty_error_on_click_of_done_click() {
        AppCache.put(Constants.MOCK.SIGN_UP_PRESENTER, SignUpPresenter())

        val mockName = "Mock Name"

        robot
            .launch(rule)
            .enterName(mockName)
            .clickDone()
            .verifyEmailEmptyErrorIsShown()
    }

    @Test
    fun should_show_mobile_no_empty_error_on_click_of_done_click() {
        AppCache.put(Constants.MOCK.SIGN_UP_PRESENTER, SignUpPresenter())

        val mockName = "Mock Name"
        val mockEmail = "mockemail@abc.com"

        robot
            .launch(rule)
            .enterName(mockName)
            .enterEmail(mockEmail)
            .clickDone()
            .verifyMobileNoEmptyErrorIsShown()
    }

    @Test
    fun should_show_password_empty_error_on_click_of_done_click() {
        AppCache.put(Constants.MOCK.SIGN_UP_PRESENTER, SignUpPresenter())

        val mockName = "Mock Name"
        val mockEmail = "mockemail@abc.com"
        val mockMobileNo = "5555555555"

        robot
            .launch(rule)
            .enterName(mockName)
            .enterEmail(mockEmail)
            .enterMobile(mockMobileNo)
            .clickDone()
            .verifyPasswordEmptyErrorIsShown()
    }

    @Test
    fun should_show_password_invalid_error_on_click_of_done_click() {
        AppCache.put(Constants.MOCK.SIGN_UP_PRESENTER, SignUpPresenter())

        val mockName = "Mock Name"
        val mockEmail = "mockemail@abc.com"
        val mockMobileNo = "5555555555"
        val mockPassword = "abc"

        robot
            .launch(rule)
            .enterName(mockName)
            .enterEmail(mockEmail)
            .enterMobile(mockMobileNo)
            .enterPassword(mockPassword)
            .clickDone()
            .verifyPasswordInvalidErrorIsShown()
    }

    @Test
    fun should_open_home_activity_on_entering_valid_input_and_successful_sign_up() {
        val mockName = "Mock Name"
        val mockEmail = "mockemail@abc.com"
        val mockMobileNo = "5555555555"
        val mockPassword = "abcdefgh"

        Intents.init()

        robot
            .launch(rule)
            .enterName(mockName)
            .enterEmail(mockEmail)
            .enterMobile(mockMobileNo)
            .enterPassword(mockPassword)
            .clickDone()
            .sendMockSuccessResponse(rule)
            .verifyHomeActivityIsOpen()

        Intents.release()
    }

}