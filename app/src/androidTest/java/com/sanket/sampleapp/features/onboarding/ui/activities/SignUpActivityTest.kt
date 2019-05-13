package com.sanket.sampleapp.features.onboarding.ui.activities

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

}