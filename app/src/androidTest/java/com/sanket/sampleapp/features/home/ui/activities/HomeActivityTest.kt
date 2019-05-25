package com.sanket.sampleapp.features.home.ui.activities


import androidx.test.rule.ActivityTestRule
import com.sanket.sampleapp.MockUtils
import com.sanket.sampleapp.application.AppCache
import com.sanket.sampleapp.application.Constants
import com.sanket.sampleapp.base.BaseInstrumentationTest
import com.sanket.sampleapp.features.home.contracts.IHomeContract
import com.sanket.sampleapp.robots.HomeRobot
import com.sanket.sampleapp.utils.saveUser
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import kotlin.random.Random

/**
 * Created by Sanket on 19/05/19.
 */
class HomeActivityTest: BaseInstrumentationTest() {

    private val rule = ActivityTestRule(HomeActivity::class.java, false, false)

    private val robot: HomeRobot by lazy { HomeRobot() }

    @Mock
    private lateinit var mockPresenter: IHomeContract.Presenter

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

    @Test
    fun should_show_reasons_to_buy_on_successful_response() {
        /**
         * Title
         * Recycler view
         */
        /*Mockito.`when`(mockPresenter.getReasonsToBuy()).then(Answer {
            return@Answer rule.activity.showReasonsToBuy(MockUtils.getReasonsToBuy(5))
        })*/
        val user = MockUtils.getUser()
        user.saveUser()

        // TODO: 25/05/19 Discuss with team how to make setup work
        robot
            .launch(rule)
//            .setupMockedReasonsToBuy(rule, mockPresenter)
            .isReasonsToBuyTitleNotVisible()
            .isReasonsToBuyListNotVisible()
            .verifyGetReasonsToBuyWasCalled(mockPresenter)
            .sendMockResponseToBuy(rule)
            .isReasonsToBuyTitleVisible()
            .isReasonsToBuyListVisible()
    }

    @Test
    fun should_not_show_reasons_to_buy_on_no_response() {
        val user = MockUtils.getUser()
        user.saveUser()

        robot
            .launch(rule)
            .isReasonsToBuyTitleNotVisible()
            .isReasonsToBuyListNotVisible()
            .verifyGetReasonsToBuyWasCalled(mockPresenter)
            .isReasonsToBuyTitleNotVisible()
            .isReasonsToBuyListNotVisible()
    }

    @Test
    fun should_show_explore_view() {
        /**
         * Title
         * Search view
         * Recycler view
         */
        val user = MockUtils.getUser()
        user.saveUser()

        val count = Random.nextInt(5, 20)

        robot
            .launch(rule)
            .isExploreViewHidden()
            .verifyGetFacilitiesWasCalled(mockPresenter)
            .sendMockFacilities(rule, count)
            .isExploreViewVisible()
    }

}