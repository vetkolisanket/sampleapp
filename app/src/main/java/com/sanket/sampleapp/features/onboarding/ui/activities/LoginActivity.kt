package com.sanket.sampleapp.features.onboarding.ui.activities

import Injection
import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.sanket.sampleapp.R
import com.sanket.sampleapp.application.Constants
import com.sanket.sampleapp.base.BaseActivity
import com.sanket.sampleapp.features.home.ui.activities.HomeActivity
import com.sanket.sampleapp.features.onboarding.contracts.ILoginContract
import com.sanket.sampleapp.features.onboarding.ui.dialogs.ForgotPasswordDialogFragment
import com.sanket.sampleapp.utils.unsafeLazy
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity(), ILoginContract.View {

    private val presenter by unsafeLazy { Injection.getLoginPresenter() }

    companion object {
        fun newIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }

    //Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onPause() {
        presenter.detachView()
        super.onPause()
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
            val transaction = supportFragmentManager.beginTransaction()
            val callback = object : ForgotPasswordDialogFragment.Callback {
                override fun onOkClick(email: String) {
                    if (presenter.isEmailValid(email)) {
                        presenter.sendResetPasswordLinkIfEmailExistsInDatabase(email)
                    }
                }
            }
            val fragment = supportFragmentManager.findFragmentByTag(Constants.FragmentTags.FORGOT_PASSWORD)
            if (fragment != null) {
                (fragment as ForgotPasswordDialogFragment).callback = callback
                fragment.show(transaction, Constants.FragmentTags.FORGOT_PASSWORD)
//                transaction.remove(fragment)
//                transaction.addToBackStack(null)
            }
            else {
                val dialogFragment = ForgotPasswordDialogFragment()
                dialogFragment.callback = callback
                dialogFragment.show(transaction, Constants.FragmentTags.FORGOT_PASSWORD)
            }
        }
    }

    //Contract

    override fun onLoginSuccess() {
        startActivity(HomeActivity.newIntent(this))
    }

    override fun showEmailEmptyError() {
        tietEmail.error = getString(R.string.error_email_empty)
        showMessage(R.string.error_email_empty)
    }

    override fun showPasswordEmptyError() {
        tietPassword.error = getString(R.string.error_password_empty)
        showMessage(R.string.error_password_empty)
    }

    override fun showPasswordInvalidError() {
        tietPassword.error = getString(R.string.error_password_invalid)
        showMessage(R.string.error_password_invalid)
    }

}
