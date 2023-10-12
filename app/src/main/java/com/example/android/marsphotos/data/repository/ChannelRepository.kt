package com.example.android.marsphotos.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.android.marsphotos.data.db.entities.Channel
import com.example.android.marsphotos.data.network.ApiService
import com.example.android.marsphotos.data.network.Exception.SafeApiRequest
import com.google.gson.JsonObject

class ChannelRepository: SafeApiRequest() {

    private val channels: MutableLiveData<List<Channel>> = MutableLiveData()

    suspend fun getChannels(map: HashMap<String,String>): JsonObject {
        return apiRequest { ApiService().getChannels(map) }

    }
}