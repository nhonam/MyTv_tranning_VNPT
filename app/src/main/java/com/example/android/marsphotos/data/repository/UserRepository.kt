package com.example.android.marsphotos.data.repository

import com.example.android.marsphotos.data.model.Orther.UserInfo
import com.example.android.marsphotos.data.network.ApiService
import com.example.android.marsphotos.data.network.Exception.SafeApiRequest
import com.google.gson.JsonObject
class UserRepository : SafeApiRequest() {

    suspend fun userLogin(map: HashMap<String,String>) : JsonObject? {

        return apiRequest {
            ApiService().loginApi(map)
        }
    }

    suspend fun getInfo(map: HashMap<String,String>): UserInfo {
        return  ApiService().getInfoAccount(map)
    }

}
