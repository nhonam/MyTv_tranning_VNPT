package com.example.android.marsphotos.data.repository

import com.example.android.marsphotos.data.model.Television.ResponseAllChannel
import com.example.android.marsphotos.data.network.ApiService
import com.example.android.marsphotos.data.network.Exception.SafeApiRequest

class ChannelRepository: SafeApiRequest() {
    suspend fun getChannels(map: HashMap<String,String>): ResponseAllChannel {
        return  ApiService().getChannels(map)

    }
}