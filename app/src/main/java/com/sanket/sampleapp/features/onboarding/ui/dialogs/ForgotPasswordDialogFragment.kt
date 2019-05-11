package com.sanket.sampleapp.features.onboarding.ui.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.sanket.sampleapp.R
import kotlinx.android.synthetic.main.dialog_forgot_password.*

/**
 * Created by Sanket on 11/05/19.
 */
class ForgotPasswordDialogFragment: DialogFragment() {

    lateinit var callback: Callback

    //Lifecycle

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.dialog_forgot_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    //Helpers

    private fun init() {
        initOnClickListeners()
    }

    private fun initOnClickListeners() {
        btnOk.setOnClickListener {
            callback.onOkClick(tietEmail.text.toString())
            dismiss()
        }
        btnCancel.setOnClickListener {
            dismiss()
        }
    }

    interface Callback {
        fun onOkClick(email: String)
    }
}