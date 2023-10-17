package com.example.android.marsphotos.data.repository

import com.example.android.marsphotos.data.model.Home.Data
import com.example.android.marsphotos.data.model.Home.ResponseHome
import com.example.android.marsphotos.data.model.film.ResponseFilm
import com.example.android.marsphotos.data.network.ApiService
import com.example.android.marsphotos.data.network.Exception.SafeApiRequest

class SlideRepository: SafeApiRequest() {


    suspend fun getSlideAndEvent(map: HashMap<String,String>): Data? {
        return  ApiService().getInforHomeApi(map).data
    }
}