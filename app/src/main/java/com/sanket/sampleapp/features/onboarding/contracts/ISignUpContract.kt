package com.sanket.sampleapp.features.onboarding.contracts

import com.sanket.sampleapp.base.IBaseContract

/**
 * Created by Sanket on 11/05/19.
 */
interface ISignUpContract {

    interface View : IBaseContract.View {

        fun showFullNameEmptyError()

        fun showInvalidEmailError()

        fun showInvalidMobileNoError()

        fun showPasswordEmptyError()

        fun showInvalidPasswordError()

        fun onSignUpSuccess()

    }

    interface Presenter : IBaseContract.Presenter<View> {

        fun isInputValid(fullName: String, email: String, mobileNo: String, password: String): Boolean

        fun signUp(fullName: String, email: String, mobileNo: String, password: String)
    }

}