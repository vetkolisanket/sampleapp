package com.sanket.sampleapp.features.onboarding.contracts

import com.sanket.sampleapp.base.IBaseContract

/**
 * Created by Sanket on 07/05/19.
 */
interface ILoginContract {

    interface View: IBaseContract.View {

        fun onLoginSuccess()

        fun showEmailEmptyError()

        fun showPasswordEmptyError()

        fun showPasswordInvalidError()

    }

    interface Presenter: IBaseContract.Presenter<View> {

        fun isInputValid(email: String, password: String) : Boolean

        fun login(email: String, password: String)

        fun isEmailValid(email: String): Boolean

        fun sendResetPasswordLinkIfEmailExistsInDatabase(email: String)

    }

}