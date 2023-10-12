package com.example.android.marsphotos.data.repository

import com.example.android.marsphotos.data.network.ApiService
import com.example.android.marsphotos.data.network.Exception.SafeApiRequest
import com.google.gson.JsonObject


class UserRepository : SafeApiRequest() {

    suspend fun userLogin(map: HashMap<String,String>) : JsonObject? {

        return apiRequest {
            ApiService().loginApi(map)
        }

    }


}
