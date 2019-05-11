package com.sanket.sampleapp.base

import android.content.Context
import androidx.annotation.StringRes
import com.sanket.sampleapp.application.Constants

/**
 * Created by Sanket on 05/05/19.
 */
interface IBaseContract {

    interface View {

        fun getContext(): Context

        fun showMessage(message: String, type: String = Constants.MessageType.TOAST)

        fun showMessage(@StringRes messageId: Int, type: String = Constants.MessageType.TOAST)

    }

    interface Presenter<V> {

        fun attachView(view: V)

        fun detachView()

    }

}