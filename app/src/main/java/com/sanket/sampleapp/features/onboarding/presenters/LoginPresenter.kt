package com.sanket.sampleapp.features.onboarding.presenters

import android.text.TextUtils
import com.sanket.sampleapp.base.UserRepository
import com.sanket.sampleapp.base.communication.RestResponse
import com.sanket.sampleapp.base.communication.RestResponseCallback
import com.sanket.sampleapp.features.onboarding.contracts.ILoginContract

/**
 * Created by Sanket on 07/05/19.
 */
class LoginPresenter: ILoginContract.Presenter {

    private var view: ILoginContract.View? = null

    override fun isInputValid(email: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(email.trim()) -> {
                view!!.showEmailEmptyError()
                false
            }
            TextUtils.isEmpty(password.trim()) -> {
                view!!.showPasswordEmptyError()
                false
            }
            password.trim().length < 4 -> {
                view!!.showPasswordInvalidError()
                false
            }
            else -> true
        }
    }

    override fun login(email: String, password: String) {
        UserRepository.login(email, password, object : RestResponseCallback<Any> {
            override fun onResponse(restResponse: RestResponse<Any>) {
                if (restResponse.status) {
                    view!!.onLoginSuccess()
                }
            }
        })
    }

    override fun attachView(view: ILoginContract.View) {
        this.view = view
        UserRepository.subscribe()
    }

    override fun detachView() {
        UserRepository.unsubscribe()
        this.view = null
    }
}