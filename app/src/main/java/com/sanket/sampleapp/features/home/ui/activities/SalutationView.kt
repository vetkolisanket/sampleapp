package com.sanket.sampleapp.features.home.ui.activities

import android.content.Context
import android.os.Build
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.sanket.sampleapp.R
import kotlinx.android.synthetic.main.view_salutation.view.*

/**
 * Created by Sanket on 22/05/19.
 */
class SalutationView: FrameLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    )

    init {
        init()
    }

    private fun init() {
        initLayout()
        initOnClickListener()
    }

    private fun initLayout() {
        (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(R.layout.view_salutation, this)
        tvTitle.text = context.getString(R.string.hey_s, "User")
    }

    private fun initOnClickListener() {
        btnActivatePass.setOnClickListener {
            Toast.makeText(context, "Activate pass", Toast.LENGTH_SHORT).show()
        }
    }

}