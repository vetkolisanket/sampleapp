package com.sanket.sampleapp.features.home.ui.activities

import Injection
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sanket.sampleapp.R
import com.sanket.sampleapp.base.BaseActivity
import com.sanket.sampleapp.features.home.contracts.IHomeContract
import com.sanket.sampleapp.features.home.models.Facility
import com.sanket.sampleapp.features.home.models.ReasonToBuy
import com.sanket.sampleapp.features.home.ui.adapters.ExploreFacilitiesAdapter
import com.sanket.sampleapp.features.home.ui.adapters.ReasonsToBuyAdapter
import com.sanket.sampleapp.utils.UiUtils
import com.sanket.sampleapp.utils.unsafeLazy
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : BaseActivity(), IHomeContract.View {

    private val presenter: IHomeContract.Presenter by unsafeLazy { Injection.getHomePresenter() }
    private val reasonsToBuyAdapter by unsafeLazy { ReasonsToBuyAdapter() }
    private val exploreFacilitiesAdapter by unsafeLazy { ExploreFacilitiesAdapter() }

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
        presenter.getFacilities()
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
        rvReasonsToBuy.adapter = reasonsToBuyAdapter
        rvExplore.layoutManager = GridLayoutManager(this, 2).also {
            it.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if (position == 0)
                        2
                    else
                        1
                }
            }
        }
        rvExplore.adapter = exploreFacilitiesAdapter
    }

    //Contract

    override fun showReasonsToBuy(reasonsToBuy: MutableList<ReasonToBuy>) {
        UiUtils.showHideViews(true, tvReasonsToBuyTitle, rvReasonsToBuy)
        reasonsToBuyAdapter.setItems(reasonsToBuy)
    }

    override fun showFacilities(facilities: MutableList<Facility>) {
        UiUtils.showHideViews(true, tvExploreTitle, svExplore, rvExplore)
        exploreFacilitiesAdapter.setItems(facilities)
    }

}
