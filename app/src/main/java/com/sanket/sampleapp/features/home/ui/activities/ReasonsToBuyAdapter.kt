package com.sanket.sampleapp.features.home.ui.activities

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanket.sampleapp.R
import com.sanket.sampleapp.base.BaseViewHolder
import com.sanket.sampleapp.features.home.ReasonToBuy
import com.sanket.sampleapp.utils.inflateView
import kotlinx.android.synthetic.main.item_reasons_to_buy.view.*

/**
 * Created by Sanket on 23/05/19.
 */
class ReasonsToBuyAdapter(private val reasonsToBuy: List<ReasonToBuy>): RecyclerView.Adapter<ReasonsToBuyAdapter.ReasonsToBuyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReasonsToBuyViewHolder {
        return ReasonsToBuyViewHolder(parent.inflateView(R.layout.item_reasons_to_buy))
    }

    override fun getItemCount(): Int {
        return reasonsToBuy.size
    }

    override fun onBindViewHolder(holder: ReasonsToBuyViewHolder, position: Int) {
        holder.bind(reasonsToBuy[position])
    }

    class ReasonsToBuyViewHolder(itemView: View) : BaseViewHolder<ReasonToBuy>(itemView) {
        override fun bind(item: ReasonToBuy) {
            itemView.tvNo.text = itemView.context.getString(R.string.h_num, adapterPosition.toString())
            itemView.tvTitle.text = item.title
            itemView.tvDescription.text = item.description
        }
    }

}