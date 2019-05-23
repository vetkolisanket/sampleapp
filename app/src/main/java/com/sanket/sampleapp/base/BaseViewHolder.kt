package com.sanket.sampleapp.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Sanket on 23/05/19.
 */
abstract class BaseViewHolder<T>(itemView: View): RecyclerView.ViewHolder(itemView) {

    abstract fun bind(item: T)

}