package com.example.android.marsphotos.data.network.Exception

import android.content.Context
import android.net.ConnectivityManager
import com.example.android.marsphotos.util.NoInternetExceptions
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnection(
    context:Context
) : Interceptor {

    private val applicationContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {

        if (isInternetAvailabel())
            throw NoInternetExceptions("Internet not Availabel !!! Connecting ......!!!")
        return chain.proceed(chain.request())
    }

    private fun isInternetAvailabel() : Boolean {
        val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        connectivityManager.activeNetworkInfo.also {
            return it != null && it.isConnected
        }
    }
}