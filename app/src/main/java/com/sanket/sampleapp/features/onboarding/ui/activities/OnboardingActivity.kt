package com.sanket.sampleapp.features.onboarding.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.sanket.sampleapp.R
import com.sanket.sampleapp.features.onboarding.ui.OnboardingAdapter
import kotlinx.android.synthetic.main.activity_onboarding.*

class OnboardingActivity : AppCompatActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, OnboardingActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        init()
    }

    private fun init() {
        initViewPager()
        initClickListeners()
    }

    private fun initClickListeners() {
        btnLogin.setOnClickListener {
            startActivity(LoginActivity.newIntent(this@OnboardingActivity))
        }
    }

    private fun initViewPager() {
        vpOnboarding.adapter = OnboardingAdapter()
        vpOnboarding.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                pivOnboarding.selection = position
            }
        })
    }
}
