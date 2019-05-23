package com.sanket.sampleapp.features.home

import com.google.gson.annotations.SerializedName

/**
 * Created by Sanket on 23/05/19.
 */
class ReasonToBuy {
    @SerializedName("title")
    lateinit var title: String

    @SerializedName("description")
    lateinit var description: String
}