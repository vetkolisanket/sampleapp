package com.sanket.sampleapp.communication

/**
 * Created by Sanket on 11/05/19.
 */
interface RestResponseCallback<T> {

    abstract fun onResponse(restResponse: RestResponse<T>)
}