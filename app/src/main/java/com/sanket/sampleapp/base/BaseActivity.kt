package com.sanket.sampleapp.base

import android.annotation.SuppressLint
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Sanket on 04/05/19.
 */
@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity() {

    protected fun initToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

}