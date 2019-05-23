package com.sanket.sampleapp.base

import com.sanket.sampleapp.communication.RestResponse
import com.sanket.sampleapp.communication.RestResponseCallback
import kotlin.random.Random

/**
 * Created by Sanket on 08/05/19.
 */
object UserRepository: BaseRepository() {
    fun login(email: String, password: String, restResponseCallback: RestResponseCallback<Any>) {
        val restResponse = RestResponse<Any>()
        restResponse.status = Random.nextBoolean()
        restResponse.message = "Something went wrong!"
        restResponseCallback.onResponse(restResponse)
    }

    fun sendResetPasswordLinkIfEmailExistsInDatabase(email: String, restResponseCallback: RestResponseCallback<Any>) {
        val restResponse = RestResponse<Any>()
        restResponse.status = Random.nextBoolean()
        restResponse.message = "Something went wrong!"
        restResponseCallback.onResponse(restResponse)
    }

    fun signUp(
        fullName: String,
        email: String,
        mobileNo: String,
        password: String,
        restResponseCallback: RestResponseCallback<Any>
    ) {
        val restResponse = RestResponse<Any>()
        restResponse.status = Random.nextBoolean()
        restResponse.message = "Something went wrong!"
        restResponseCallback.onResponse(restResponse)
    }
}