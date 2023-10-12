package com.example.android.marsphotos.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.android.marsphotos.data.db.entities.Slide
import com.example.android.marsphotos.data.network.ApiService
import com.example.android.marsphotos.data.network.Exception.SafeApiRequest
import com.google.gson.JsonObject

class SlideRepository: SafeApiRequest() {

    private val imageList: MutableLiveData<List<Slide>> = MutableLiveData()

    suspend fun getImageList(map: HashMap<String,String>): JsonObject {
        return apiRequest { ApiService().getInforHomeApi(map) }

    }
}