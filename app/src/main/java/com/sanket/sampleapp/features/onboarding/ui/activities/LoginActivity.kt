package com.sanket.sampleapp.features.onboarding.ui.activities

import Injection
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.sanket.sampleapp.R
import com.sanket.sampleapp.base.BaseActivity
import com.sanket.sampleapp.features.onboarding.contracts.ILoginContract
import com.sanket.sampleapp.utils.unsafeLazy
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), ILoginContract.View {

    val presenter by unsafeLazy { Injection.getLoginPresenter() }

    companion object {
        fun newIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }

    //Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
    }

    //Helper

    private fun init() {
        initToolbar()
        initOnClickListeners()
    }

    private fun initOnClickListeners() {
        btnLogin.setOnClickListener {
            val email = tietEmail.text.toString()
            val password = tietPassword.text.toString()
            if (presenter.isInputValid(email, password)) {
                presenter.login(email, password)
            }
        }
        tvForgotPassword.setOnClickListener {

        }
    }

    //Contract

    override fun onLoginSuccess() {
        startActivity(HomeActivity.newIntent(this))
    }

    override fun showEmailEmptyError() {
        tietEmail.error = getString(R.string.error_email_empty)
    }

    override fun showPasswordEmptyError() {
        tietPassword.error = getString(R.string.error_password_empty)
    }

    override fun showPasswordInvalidError() {
        tietPassword.error = getString(R.string.error_password_invalid)
    }

}
