package com.sanket.sampleapp.features.onboarding.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.sanket.sampleapp.R
import com.sanket.sampleapp.base.BaseActivity

class SignUpActivity : BaseActivity() {

    companion object {
        fun newIntent(context: Context) = Intent(context, SignUpActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        init()
    }

    private fun init() {
        initToolbar()
    }

}
