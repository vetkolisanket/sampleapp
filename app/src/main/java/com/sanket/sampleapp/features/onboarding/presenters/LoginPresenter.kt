package com.sanket.sampleapp.features.onboarding.presenters

import android.text.TextUtils
import com.sanket.sampleapp.features.onboarding.contracts.ILoginContract

/**
 * Created by Sanket on 07/05/19.
 */
class LoginPresenter: ILoginContract.Presenter {

    private var view: ILoginContract.View? = null

    override fun isInputValid(email: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(email.trim()) -> {
                view?.showEmailEmptyError()
                false
            }
            TextUtils.isEmpty(password.trim()) -> {
                view?.showPasswordEmptyError()
                false
            }
            password.trim().length < 4 -> {
                view?.showPasswordInvalidError()
                false
            }
            else -> true
        }
    }

    override fun login(email: String, password: String) {

    }

    override fun attachView(view: ILoginContract.View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }
}