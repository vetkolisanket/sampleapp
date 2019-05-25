package com.sanket.sampleapp.features.home.contracts

import com.sanket.sampleapp.base.IBaseContract
import com.sanket.sampleapp.features.home.models.Facility
import com.sanket.sampleapp.features.home.models.ReasonToBuy

/**
 * Created by Sanket on 25/05/19.
 */
interface IHomeContract {

    interface View : IBaseContract.View {

        fun showReasonsToBuy(reasonsToBuy: MutableList<ReasonToBuy>)

        fun showFacilities(facilities: MutableList<Facility>)

    }

    interface Presenter : IBaseContract.Presenter<View> {

        fun getReasonsToBuy()

        fun getFacilities()

    }

}