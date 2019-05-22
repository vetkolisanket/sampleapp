package com.sanket.sampleapp

/**
 * Created by Sanket on 22/05/19.
 */
object MockUtils {

    fun getUser(): User {
        val user = User()
        user.name = "Mock"
        return user
    }

}