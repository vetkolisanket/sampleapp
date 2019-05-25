package com.sanket.sampleapp.features.home.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Sanket on 25/05/19.
 */
class Facility {

    @SerializedName("name")
    lateinit var name: String

    @SerializedName("count")
    var count: Int = 0

    @SerializedName("url")
    lateinit var url: String

}