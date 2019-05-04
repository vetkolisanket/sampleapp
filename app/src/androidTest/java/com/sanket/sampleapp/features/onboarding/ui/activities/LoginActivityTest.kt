package com.sanket.sampleapp.features.onboarding.ui.activities

import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.sanket.sampleapp.base.BaseInstrumentationTest
import com.sanket.sampleapp.robots.LoginRobot
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Sanket on 04/05/19.
 */
@RunWith(AndroidJUnit4::class)
class LoginActivityTest: BaseInstrumentationTest() {

    private val rule = ActivityTestRule(LoginActivity::class.java, false, false)

    private val robot: LoginRobot by lazy { LoginRobot() }

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
    fun should_show_error_on_login_btn_click_with_no_input() {
        robot
            .launch(rule)
            .isLoginBtnVisible()
            .clickLoginBtn()
            .sendMockFailureResponse(rule)
            .isErrorShown()
    }

    @Test
    fun should_show_error_on_entering_invalid_password() {

    }

    @Test
    fun should_show_error_on_entering_password_without_email() {

    }

    @Test
    fun should_show_error_on_providing_valid_input_and_getting_failure_response_from_backend() {

    }

    @Test
    fun should_go_to_home_activity_on_providing_valid_input_and_getting_successful_response_from_backend() {

    }

    @Test
    fun should_open_forgot_password_dialog_on_click_of_forgot_password_text() {

    }

    @Test
    fun should_successfully_submit_email_on_submitting_valid_email_in_forgot_password_dialog() {

    }

    @Test
    fun should_show_error_on_submitting_invalid_email_in_forgot_password_dialog() {

    }

}