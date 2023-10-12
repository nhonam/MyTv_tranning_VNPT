package com.example.android.marsphotos.util


import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import com.example.android.marsphotos.R




object LoadingCustom {
    private var dialog: AlertDialog? = null
    private var activity: Activity? = null

    fun initialize(activity: Activity) {
        this.activity = activity
    }

    @SuppressLint("InflateParams")
    fun startLoadingDialog() {
        if (activity == null) {
            throw IllegalStateException("You must call initialize() first.")
        }

        val builder = AlertDialog.Builder(activity!!)

        val inflater = activity!!.layoutInflater
        builder.setView(inflater.inflate(R.layout.loading, null))
        builder.setCancelable(true)
        dialog = builder.create()
        dialog!!.show()
    }

    fun dismissDialog() {
        dialog?.dismiss()
    }
}