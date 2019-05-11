package com.sanket.sampleapp.features.onboarding.presenters

import com.sanket.sampleapp.base.UserRepository
import com.sanket.sampleapp.base.communication.RestResponse
import com.sanket.sampleapp.base.communication.RestResponseCallback
import com.sanket.sampleapp.features.onboarding.contracts.ISignUpContract

/**
 * Created by Sanket on 11/05/19.
 */
class SignUpPresenter: ISignUpContract.Presenter {

    var view: ISignUpContract.View? = null

    override fun attachView(view: ISignUpContract.View) {
        this.view = view
        UserRepository.subscribe()
    }

    override fun detachView() {
        UserRepository.unsubscribe()
        this.view = null
    }

    override fun isInputValid(fullName: String, email: String, mobileNo: String, password: String): Boolean {
        return when {
            fullName.isBlank() -> {
                view!!.showFullNameEmptyError()
                false
            }
            email.isBlank() -> {
                view!!.showInvalidEmailError()
                false
            }
            mobileNo.isBlank() or (mobileNo.length != 10) -> {
                view!!.showInvalidMobileNoError()
                false
            }
            password.isBlank() -> {
                view!!.showPasswordEmptyError()
                false
            }
            password.length < 4 -> {
                view!!.showInvalidPasswordError()
                false
            }
            else -> true
        }
    }

    override fun signUp(fullName: String, email: String, mobileNo: String, password: String) {
        UserRepository.signUp(fullName, email, mobileNo, password, object : RestResponseCallback<Any> {
            override fun onResponse(restResponse: RestResponse<Any>) {
                if (restResponse.status) {
                    view!!.onSignUpSuccess()
                } else {
                    view!!.showMessage(restResponse.message!!)
                }
            }
        })
    }
}