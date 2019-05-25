package com.sanket.sampleapp.features.home.ui.activities

import Injection
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.sanket.sampleapp.R
import com.sanket.sampleapp.base.BaseActivity
import com.sanket.sampleapp.features.home.ReasonToBuy
import com.sanket.sampleapp.features.home.contracts.IHomeContract
import com.sanket.sampleapp.utils.UiUtils
import com.sanket.sampleapp.utils.unsafeLazy
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(), IHomeContract.View {

    private val presenter: IHomeContract.Presenter by unsafeLazy { Injection.getHomePresenter() }
    private val adapter by unsafeLazy { ReasonsToBuyAdapter() }

    companion object {
        fun newIntent(context: Context) = Intent(context, HomeActivity::class.java)
    }

    //Lifecycle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
        presenter.getReasonsToBuy()
    }

    override fun onPause() {
        presenter.detachView()
        super.onPause()
    }

    //Helpers

    private fun init() {
        initToolbar()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        rvReasonsToBuy.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvReasonsToBuy.adapter = adapter
    }

    //Contract

    override fun showReasonsToBuy(reasonsToBuy: MutableList<ReasonToBuy>) {
        UiUtils.showHideViews(true, tvReasonsToBuyTitle, rvReasonsToBuy)
        adapter.setItems(reasonsToBuy)
    }

}
