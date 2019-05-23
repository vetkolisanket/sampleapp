package com.sanket.sampleapp.base

import android.content.SharedPreferences
import com.sanket.sampleapp.application.App
import com.sanket.sampleapp.communication.ResponseObserverHelper
import com.sanket.sampleapp.utils.unsafeLazy
import java.util.ArrayList

/**
 * Created by Sanket on 08/05/19.
 */
abstract class BaseRepository {

    protected var isSubscribed: Boolean = false

    val responseObserverHelpers: List<ResponseObserverHelper<Any>>? by unsafeLazy { ArrayList<ResponseObserverHelper<Any>>() }

    fun getPreferences(): SharedPreferences {
        return App.getPreferences()
    }

    fun unsubscribe() {
        isSubscribed = false

        for (helper in responseObserverHelpers!!) {
                helper.dispose()
        }
    }

    fun subscribe() {
        isSubscribed = true
    }
}