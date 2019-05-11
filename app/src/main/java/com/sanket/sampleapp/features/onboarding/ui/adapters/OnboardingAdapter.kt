package com.sanket.sampleapp.features.onboarding.ui.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanket.sampleapp.R
import com.sanket.sampleapp.utils.inflateView

/**
 * Created by Sanket on 28/04/19.
 */
class OnboardingAdapter: RecyclerView.Adapter<OnboardingAdapter.PageVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageVH {
        return PageVH(parent.inflateView(R.layout.item_onboarding))
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: PageVH, position: Int) {

    }

    class PageVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}