package com.sanket.sampleapp

import com.sanket.sampleapp.features.home.models.Facility
import com.sanket.sampleapp.features.home.models.ReasonToBuy

/**
 * Created by Sanket on 22/05/19.
 */
object MockUtils {

    fun getUser(): User {
        val user = User()
        user.name = "Mock"
        return user
    }

    // TODO: 25/05/19 ask Jay is there a better way to loop than the way I have used
    fun getReasonsToBuy(count: Int): MutableList<ReasonToBuy> {
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

    fun getFacilities(count: Int): MutableList<Facility> {
        val facilities = mutableListOf<Facility>()
        for (item in 0 until count) {
            facilities.add(getFacility())
        }
        return facilities
    }

    fun getFacility(): Facility {
        return Facility()
    }
}