package com.sanket.sampleapp.features.home.ui.activities


import androidx.test.rule.ActivityTestRule
import com.sanket.sampleapp.MockUtils
import com.sanket.sampleapp.application.AppCache
import com.sanket.sampleapp.application.Constants
import com.sanket.sampleapp.base.BaseInstrumentationTest
import com.sanket.sampleapp.features.home.presenters.HomePresenter
import com.sanket.sampleapp.robots.HomeRobot
import com.sanket.sampleapp.utils.saveUser
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

/**
 * Created by Sanket on 19/05/19.
 */
class HomeActivityTest: BaseInstrumentationTest() {

    private val rule = ActivityTestRule(HomeActivity::class.java, false, false)

    private val robot: HomeRobot by lazy { HomeRobot() }

    @Mock
    private lateinit var mockPresenter: HomePresenter

    @Before
    override fun setup() {
        super.setup()
        MockitoAnnotations.initMocks(this)
        AppCache.put(Constants.MOCK.HOME_PRESENTER, mockPresenter)
    }

    @Test
    fun launch_activity() {
        robot.launch(rule)
    }

    @Test
    fun should_show_salutation_card() {
        val user = MockUtils.getUser()
        user.saveUser()

        robot
            .launch(rule)
            .isSalutationCardVisible()
    }

}