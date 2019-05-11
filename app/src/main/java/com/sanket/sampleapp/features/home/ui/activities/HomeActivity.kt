package com.sanket.sampleapp.features.home.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.sanket.sampleapp.R
import com.sanket.sampleapp.base.BaseActivity

class HomeActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()
    }

    private fun init() {
        initToolbar()
    }
}
