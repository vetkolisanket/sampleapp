package com.sanket.sampleapp.robots

import androidx.test.core.app.ApplicationProvider
import androidx.test.rule.ActivityTestRule
import com.sanket.sampleapp.R
import com.sanket.sampleapp.base.Espresso
import com.sanket.sampleapp.features.home.ui.activities.HomeActivity

class HomeRobot {
    fun launch(rule: ActivityTestRule<HomeActivity>): HomeRobot {
        rule.launchActivity(HomeActivity.newIntent(ApplicationProvider.getApplicationContext()))
        return this
    }

    fun isSalutationCardVisible() {
        Espresso.isViewVisible(R.id.cvSalutation)
    }
}
