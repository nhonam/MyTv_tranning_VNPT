package com.example.android.marsphotos.data.repository

import com.example.android.marsphotos.data.model.film.ResponseFilm
import com.example.android.marsphotos.data.network.ApiService

class FilmRepository {

    suspend fun getCategoryFilmAndFilmItem(map: HashMap<String,String>): ResponseFilm {
        return  ApiService().getCategoryFilmAndFilmItem(map)

    }
}