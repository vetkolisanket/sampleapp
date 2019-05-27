package com.sanket.sampleapp.features.home.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanket.sampleapp.R
import com.sanket.sampleapp.base.BaseViewHolder
import com.sanket.sampleapp.features.home.models.Facility
import com.sanket.sampleapp.utils.inflateView
import com.sanket.sampleapp.utils.load
import com.sanket.sampleapp.utils.unsafeLazy
import kotlinx.android.synthetic.main.item_facilities.view.*

/**
 * Created by Sanket on 25/05/19.
 */
class ExploreFacilitiesAdapter: RecyclerView.Adapter<ExploreFacilitiesAdapter.ExploreFacilitiesViewHolder>() {

    private val facilities by unsafeLazy { mutableListOf<Facility>() }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreFacilitiesViewHolder {
        return ExploreFacilitiesViewHolder(parent.inflateView(R.layout.item_facilities))
    }

    override fun getItemCount(): Int {
        return facilities.size
    }

    override fun onBindViewHolder(holder: ExploreFacilitiesViewHolder, position: Int) {
        holder.bind(facilities[position])
    }

    fun setItems(items: MutableList<Facility>) {
        facilities.clear()
        facilities.addAll(items)
        notifyDataSetChanged()
    }

    class ExploreFacilitiesViewHolder(itemView: View) : BaseViewHolder<Facility>(itemView) {
        override fun bind(item: Facility) {
            itemView.tvActivity.text = itemView.context.getString(R.string.s_n_s_activities, item.name, item.count.toString())
            itemView.ivFacility.load(item.url)
        }
    }

}