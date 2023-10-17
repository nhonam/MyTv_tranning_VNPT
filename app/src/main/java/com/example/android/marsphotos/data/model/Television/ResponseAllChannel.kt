package com.example.android.marsphotos.data.model.Television

data class ResponseAllChannel(
    val IP_SERVER: String,
    val `data`: List<Channel>,
    val ip_client: String,
    val result: Int,
    val ser_time: String,
    val time_exec: Int
)