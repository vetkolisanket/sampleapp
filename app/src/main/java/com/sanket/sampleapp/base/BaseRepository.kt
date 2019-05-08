package com.sanket.sampleapp.base

/**
 * Created by Sanket on 08/05/19.
 */
abstract class BaseRepository {

    private var isSubscribed: Boolean  = false

//    protected fun getPreferences() = App.getSharedPreferences()

    fun subscribe() {
        isSubscribed = true
    }

    fun unsubscribe() {
        isSubscribed = false
    }

}