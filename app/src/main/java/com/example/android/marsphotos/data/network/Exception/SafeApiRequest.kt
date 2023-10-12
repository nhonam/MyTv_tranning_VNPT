package com.example.android.marsphotos.data.network.Exception

import com.example.android.marsphotos.util.ApiExceptions
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response

abstract class SafeApiRequest {

    suspend   fun<T:Any> apiRequest(call: suspend () -> Response<T>): T {
        val response = call.invoke()
        if (response.isSuccessful)
            return response.body()!!
        else{
            val  message = java.lang.StringBuilder()
            val error = response.errorBody()?.toString()
            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                }catch (e: JSONException) {
                    message.append("\n")
                }

            }

            message.append("ERROR CODE :${response.code()}")

            throw ApiExceptions(message.toString())
        }
    }
}