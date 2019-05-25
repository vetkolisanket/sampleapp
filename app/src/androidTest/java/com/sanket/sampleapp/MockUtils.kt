package com.sanket.sampleapp

import com.sanket.sampleapp.features.home.models.Facility
import com.sanket.sampleapp.features.home.models.ReasonToBuy
import kotlin.random.Random

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

        val facility = Facility()
        facility.name = "Exclusives"
        facility.count = Random.nextInt(5, 1000)
        facility.url = getDummyPicUrl()
        return facility
    }

    fun getDummyPicUrl(): String {
        var url: String = ""
        when (java.util.Random().nextInt(4)) {
            0 -> url = "http://i.imgur.com/DCE503d.jpg"
            1 -> url =
                "https://images-na.ssl-images-amazon.com/images/M/MV5BMTQ1Mzg3NTA0OF5BMl5BanBnXkFtZTcwNTgyNTM5OQ@@._V1_SY1000_CR0,0,1333,1000_AL_.jpg"
            2 -> url =
                "http://images2.fanpop.com/image/photos/8800000/Scarlett-Johansson-scarlett-johansson-8836765-500-375.jpg"
            3 -> url =
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS4dOL_TEyZbZWrCDaNkxNGIqDSKDcnN9iNGA8c8THuvZnRE-an"
        }
        return url
    }

}