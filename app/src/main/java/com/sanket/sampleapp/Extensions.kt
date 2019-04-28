package com.sanket.sampleapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes

/**
 * Created by Sanket on 28/04/19.
 */
fun ViewGroup.inflateView(@LayoutRes viewId: Int) = LayoutInflater.from(this.context).inflate(viewId, this, false)
