package com.sanket.sampleapp.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.sanket.sampleapp.BuildConfig
import com.sanket.sampleapp.application.Constants

/**
 * Created by Sanket on 28/04/19.
 */
fun ViewGroup.inflateView(@LayoutRes viewId: Int) = LayoutInflater.from(this.context).inflate(viewId, this, false)

fun <T> Any.unsafeLazy(initializer: () -> T) = lazy(LazyThreadSafetyMode.NONE, initializer)

fun Any.isProduction() = BuildConfig.FLAVOR == Constants.BuildType.PROD

