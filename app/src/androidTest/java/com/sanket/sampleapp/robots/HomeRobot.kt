package com.sanket.sampleapp.robots

import androidx.test.core.app.ApplicationProvider
import androidx.test.rule.ActivityTestRule
import com.sanket.sampleapp.MockUtils
import com.sanket.sampleapp.R
import com.sanket.sampleapp.base.Espresso
import com.sanket.sampleapp.features.home.contracts.IHomeContract
import com.sanket.sampleapp.features.home.ui.activities.HomeActivity
import org.mockito.Mockito
import org.mockito.stubbing.Answer

class HomeRobot {
    fun launch(rule: ActivityTestRule<HomeActivity>): HomeRobot {
        rule.launchActivity(HomeActivity.newIntent(ApplicationProvider.getApplicationContext()))
        return this
    }

    fun isSalutationCardVisible() {
        Espresso.isViewVisible(R.id.cvSalutation)
    }

    fun verifyGetReasonsToBuyWasCalled(presenter: IHomeContract.Presenter): HomeRobot {
        Mockito.verify(presenter).getReasonsToBuy()
        return this
    }

    fun setupMockedReasonsToBuy(rule: ActivityTestRule<HomeActivity>, presenter: IHomeContract.Presenter): HomeRobot {
        Mockito.`when`(presenter.getReasonsToBuy()).then(getReasonsToBuy(rule))
        return this
    }

    private fun getReasonsToBuy(rule: ActivityTestRule<HomeActivity>): Answer<Unit> {
        return Answer {
            return@Answer rule.activity.runOnUiThread {
                rule.activity.showReasonsToBuy(MockUtils.getReasonsToBuy(5))
            }
        }
    }

    fun isReasonsToBuyTitleVisible(): HomeRobot {
        Espresso.isViewVisible(R.id.tvReasonsToBuyTitle)
        return this
    }

    fun isReasonsToBuyListVisible() {
        Espresso.isViewVisible(R.id.rvReasonsToBuy)
    }

    fun sendMockResponseToBuy(rule: ActivityTestRule<HomeActivity>): HomeRobot {
        rule.activity.runOnUiThread {
            rule.activity.showReasonsToBuy(MockUtils.getReasonsToBuy(5))
        }
        return this
    }

    fun isReasonsToBuyTitleNotVisible(): HomeRobot {
        Espresso.isViewHidden(R.id.tvReasonsToBuyTitle)
        return this
    }

    fun isReasonsToBuyListNotVisible(): HomeRobot {
        Espresso.isViewHidden(R.id.rvReasonsToBuy)
        return this
    }
}
