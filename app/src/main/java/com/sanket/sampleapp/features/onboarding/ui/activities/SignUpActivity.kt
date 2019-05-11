package com.sanket.sampleapp.features.onboarding.ui.activities

import Injection
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.TextPaint
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.View
import com.sanket.sampleapp.R
import com.sanket.sampleapp.base.BaseActivity
import com.sanket.sampleapp.features.home.ui.activities.HomeActivity
import com.sanket.sampleapp.features.onboarding.contracts.ISignUpContract
import com.sanket.sampleapp.utils.unsafeLazy
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : BaseActivity(), ISignUpContract.View {

    private val presenter: ISignUpContract.Presenter by unsafeLazy { Injection.getSignUpPresenter() }

    companion object {
        fun newIntent(context: Context) = Intent(context, SignUpActivity::class.java)
    }

    //Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.sanket.sampleapp.R.layout.activity_sign_up)

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
        initViews()
    }

    private fun initViews() {
        initLoginView()
        initTOSView()
        initOnClickListeners()
    }

    private fun initOnClickListeners() {
        btnDone.setOnClickListener {
            val fullName = tietFullName.text.toString()
            val email = tietEmail.text.toString()
            val mobileNo = tietMobile.text.toString()
            val password = tietPassword.text.toString()
            if (presenter.isInputValid(fullName, email, mobileNo, password)) {
                presenter.signUp(fullName, email, mobileNo, password)
            }
        }
    }

    private fun initTOSView() {
        val tosPart1 = getString(R.string.tos_part_1)
        val tosPart2 = getString(R.string.tos_part_2)
        val spannableString = SpannableString("$tosPart1 $tosPart2")
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                showMessage("Open tnc in web view or chrome custom tab")
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = true
            }
        }
        spannableString.setSpan(
            clickableSpan,
            tosPart1.length+1,
            spannableString.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tvTOS.text = spannableString
        tvTOS.movementMethod = LinkMovementMethod.getInstance()
    }

    private fun initLoginView() {
        val alreadyAMember = getString(R.string.already_a_member)
        val login = getString(R.string.login)
        val spannableString = SpannableString("$alreadyAMember $login")
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(textView: View) {
                startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
            }

            override fun updateDrawState(ds: TextPaint) {
                super.updateDrawState(ds)
                ds.isUnderlineText = false
            }
        }
        spannableString.setSpan(
            clickableSpan,
            alreadyAMember.length+1,
            spannableString.length,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        tvLogin.text = spannableString
        tvLogin.movementMethod = LinkMovementMethod.getInstance()
    }

    //Contract

    override fun showFullNameEmptyError() {
        val errorMessage = getString(R.string.error_full_name_empty)
        tietFullName.error = errorMessage
        showMessage(errorMessage)
    }

    override fun showInvalidEmailError() {
        val errorMessage = getString(R.string.error_email_empty)
        tietEmail.error = errorMessage
        showMessage(errorMessage)
    }

    override fun showInvalidMobileNoError() {
        val errorMessage = getString(R.string.error_mobile_no_invalid)
        tietMobile.error = errorMessage
        showMessage(errorMessage)
    }

    override fun showPasswordEmptyError() {
        val errorMessage = getString(R.string.error_password_empty)
        tietPassword.error = errorMessage
        showMessage(errorMessage)
    }

    override fun showInvalidPasswordError() {
        val errorMessage = getString(R.string.error_password_invalid)
        tietPassword.error = errorMessage
        showMessage(errorMessage)
    }

    override fun onSignUpSuccess() {
        startActivity(HomeActivity.newIntent(this))
    }

}
