package com.sanket.sampleapp.application

/**
 * Created by Sanket on 02/05/19.
 */
object Constants {
    object FragmentTags {
        const val FORGOT_PASSWORD = "forgotPassword"
    }

    const val LOGGER_TAG = "sampleApp"

    object BuildType {
        const val MOCK = "mock"
        const val PROD = "prod"
        const val STAGING = "staging"
    }

    object MessageType {
        const val TOAST = "toast"
        const val SNACKBAR = "snackbar"
    }

    object MOCK {
        const val LOGIN_PRESENTER: String = "MockLoginPresenter"
        const val SIGN_UP_PRESENTER: String = "MockSignUpPresenter"
    }
}