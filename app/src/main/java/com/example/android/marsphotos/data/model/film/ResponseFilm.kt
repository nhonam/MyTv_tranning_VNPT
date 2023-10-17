package com.example.android.marsphotos.data.model.film

data class ResponseFilm(
    val IP_SERVER: String,
    val `data`: Data,
    val ip_client: String,
    val message: String,
    val optional: Optional,
    val result: Int,
    val ser_time: String,
    val time_exec: Int
)