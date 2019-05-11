package com.sanket.sampleapp.base.communication

import com.sanket.sampleapp.utils.isProduction
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * Created by Sanket on 11/05/19.
 */
class ResponseObserverHelper<T>(private val callback: RestResponseCallback<T>): Observer<RestResponse<T>> {

    private var restResponse: RestResponse<T>? = null
    private var disposable: Disposable? = null

    override fun onSubscribe(d: Disposable) {
        this.disposable = d
    }

    override fun onNext(restResponse: RestResponse<T>) {
        this.restResponse = restResponse
    }

    override fun onError(e: Throwable) {
        restResponse = RestResponse()

        restResponse!!.status = false
        restResponse!!.message = getExtraMessage(e)
        callback.onResponse(restResponse!!)
    }

    override fun onComplete() {
        restResponse!!.status = true
        restResponse!!.receivedTimestamp = System.currentTimeMillis()
        callback.onResponse(restResponse!!)
    }

    fun dispose() {
        if (disposable != null) {
            this.disposable!!.dispose()
        }
    }

    /**
     * Helper method to parse REST contract response incase of error;
     *
     * @param error
     */

    private fun getExtraMessage(error: Throwable): String {
        var extraMessage = ""
        if (error is RetrofitException) {
            try {
                val response = error.getErrorBodyAs(RestResponse::class.java)
                extraMessage = response!!.message + getErrorMessage(error)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        return " $extraMessage"
    }

    private fun getErrorMessage(error: Throwable): String? {
        return if (!isProduction()) {
            error.message
        } else ""
    }

}