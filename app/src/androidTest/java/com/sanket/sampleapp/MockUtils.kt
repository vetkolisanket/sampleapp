package com.sanket.sampleapp

import com.sanket.sampleapp.features.home.ReasonToBuy

/**
 * Created by Sanket on 22/05/19.
 */
object MockUtils {

    fun getUser(): User {
        val user = User()
        user.name = "Mock"
        return user
    }

    fun getReasonsToBuy(count: Int): List<ReasonToBuy> {
        val reasonsToBuy = mutableListOf<ReasonToBuy>()
        for (item in 0 until count) {
            reasonsToBuy.add(getReasonToBuy())
        }
        return reasonsToBuy
    }

    fun getReasonToBuy(): ReasonToBuy {
        val reasonToBuy = ReasonToBuy()
        reasonToBuy.title = "Mock title"
        reasonToBuy.description = "Mock description"
        return reasonToBuy
    }

}