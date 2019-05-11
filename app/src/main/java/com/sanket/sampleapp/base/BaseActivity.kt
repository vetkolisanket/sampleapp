package com.sanket.sampleapp.base

import android.annotation.SuppressLint
import android.content.Context
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by Sanket on 04/05/19.
 */
@SuppressLint("Registered")
open class BaseActivity: AppCompatActivity(), IBaseContract.View {

    override fun getContext(): Context {
        return this
    }

    override fun showMessage(message: String, type: String) {
        toast(message)
    }

    override fun showMessage(messageId: Int, type: String) {
        showMessage(getString(messageId), type)
    }

    protected fun initToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    fun toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show()
    }

}