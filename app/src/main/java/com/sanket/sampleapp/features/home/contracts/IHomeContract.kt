package com.sanket.sampleapp.features.home.contracts

import com.sanket.sampleapp.base.IBaseContract
import com.sanket.sampleapp.features.home.ReasonToBuy

/**
 * Created by Sanket on 25/05/19.
 */
interface IHomeContract {

    interface View : IBaseContract.View {

        fun showReasonsToBuy(reasonsToBuy: MutableList<ReasonToBuy>)

    }

    interface Presenter : IBaseContract.Presenter<View> {

        fun getReasonsToBuy(): MutableList<ReasonToBuy>

    }

}