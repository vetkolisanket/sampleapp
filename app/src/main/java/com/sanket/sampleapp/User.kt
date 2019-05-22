package com.sanket.sampleapp

import com.sanket.sampleapp.application.App
import com.sanket.sampleapp.application.Constants
import com.sanket.sampleapp.utils.GsonUtils

/**
 * Created by Sanket on 22/05/19.
 */
class User {

    companion object {
        fun getUser(): User? {
            val user = GsonUtils.getObjectFromJson<User>(
                App.getPreferences().getString(Constants.BUNDLE_KEYS.USER, ""),
                User::class.java
            )
            return user
        }
    }

    lateinit var name: String

}