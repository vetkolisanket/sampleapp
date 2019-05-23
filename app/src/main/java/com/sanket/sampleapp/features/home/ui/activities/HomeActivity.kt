package com.sanket.sampleapp.features.home.ui.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sanket.sampleapp.R
import com.sanket.sampleapp.base.BaseActivity
import com.sanket.sampleapp.features.home.ReasonToBuy
import com.sanket.sampleapp.utils.unsafeLazy
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity() {

    private val reasonsToBuy: MutableList<ReasonToBuy> by unsafeLazy { mutableListOf<ReasonToBuy>() }

    companion object {
        fun newIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()
    }

    private fun init() {
        initToolbar()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        reasonsToBuy.addAll(getReasonsToBuy(5))
        rvReasonsToBuy.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvReasonsToBuy.adapter = ReasonsToBuyAdapter(reasonsToBuy)
    }

    // TODO: 23/05/19 remove
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
