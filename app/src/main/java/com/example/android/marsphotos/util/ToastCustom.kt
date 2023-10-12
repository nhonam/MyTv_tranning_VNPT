package com.example.android.marsphotos.util

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.example.android.marsphotos.R



class ToastCustom(context: Context?) : Toast(context) {
    override fun setGravity(gravity: Int, xOffset: Int, yOffset: Int) {
        super.setGravity(gravity, xOffset, yOffset)
    }

    companion object {
        var SUCCESS = 1
        var WARNING = 2
        var ERROR = 3
        var CONFUSING = 4
        private const val SHORT: Long = 4000
        private const val LONG: Long = 7000
        fun makeText(
            context: Context?,
            message: String?,
            duration: Int,
            type: Int,
            androidicon: Boolean
        ): Toast {
            val toast = Toast(context)
            toast.duration = duration
            toast.setGravity(Gravity.TOP or Gravity.CENTER, 0, 0)
            val layout: View =
                LayoutInflater.from(context).inflate(R.layout.customtoast_layout, null, false)
            val l1 = layout.findViewById<View>(R.id.toast_text) as TextView
            val linearLayout = layout.findViewById<View>(R.id.toast_type) as LinearLayout
            val img = layout.findViewById<View>(R.id.toast_icon) as ImageView
            l1.text = message
            if (type == 1) {
                linearLayout.setBackgroundResource(R.drawable.success_shape)
                img.setImageResource(R.drawable.ic_check_black_24dp)
            } else if (type == 2) {
                linearLayout.setBackgroundResource(R.drawable.warning_shape)
                img.setImageResource(R.drawable.baseline_pan_tool_24)
            } else if (type == 3) {
                linearLayout.setBackgroundResource(R.drawable.error_shape)
                img.setImageResource(R.drawable.baseline_clear_24)
            } else if (type == 4) {
                linearLayout.setBackgroundResource(R.drawable.confusing_shape)
                img.setImageResource(R.drawable.baseline_rotate_left_24)
            }
            toast.setView(layout)
            return toast
        }

        fun makeText(
            context: Context?,
            message: String?,
            duration: Int,
            type: Int,
            ImageResource: Int
        ): Toast {
            val toast = Toast(context)
            val layout: View =
                LayoutInflater.from(context).inflate(R.layout.customtoast_layout, null, false)
            val l1 = layout.findViewById<View>(R.id.toast_text) as TextView
            val linearLayout = layout.findViewById<View>(R.id.toast_type) as LinearLayout
            val img = layout.findViewById<View>(R.id.toast_icon) as ImageView
            l1.text = message
            if (type == 1) {
                linearLayout.setBackgroundResource(R.drawable.success_shape)
                img.setImageResource(ImageResource)
            } else if (type == 2) {
                linearLayout.setBackgroundResource(R.drawable.warning_shape)
                img.setImageResource(ImageResource)
            } else if (type == 3) {
                linearLayout.setBackgroundResource(R.drawable.error_shape)
                img.setImageResource(ImageResource)
            } else if (type == 4) {
                linearLayout.setBackgroundResource(R.drawable.confusing_shape)
                img.setImageResource(ImageResource)
            }
            toast.setView(layout)
            return toast
        }
    }
}