package com.sanket.sampleapp

import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.sanket.sampleapp.features.onboarding.ui.OnboardingActivity
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations

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
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun launchActivity() {
        robot.launch(rule)
    }

}