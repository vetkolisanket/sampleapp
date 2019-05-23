package com.sanket.sampleapp.communication

import com.google.gson.annotations.SerializedName

/**
 * Created by Sanket on 11/05/19.
 */
class RestResponse<T> {

    @SerializedName("responseData")
    var data: T? = null

    @SerializedName("message")
    var message: String? = null

    @SerializedName("status")
    var status: Boolean = false

    @SerializedName("receivedTimestamp")
    var receivedTimestamp: Long = 0
}