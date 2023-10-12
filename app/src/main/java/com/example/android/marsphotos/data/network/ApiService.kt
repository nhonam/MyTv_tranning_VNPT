package com.example.android.marsphotos.data.network

import com.google.gson.JsonObject
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface ApiService {
    @FormUrlEncoded
    @POST("authen-v7")
    suspend fun loginApi(@FieldMap map: HashMap<String, String>): Response<JsonObject>

    @FormUrlEncoded
    @POST("home-page1-v2")
    suspend fun getInforHomeApi(@FieldMap map: HashMap<String, String>): Response<JsonObject>

    @FormUrlEncoded
    @POST("channel/list-v3")
    suspend fun getChannels(@FieldMap map: HashMap<String, String>): Response<JsonObject>




    companion object{
        operator fun invoke(

        ):ApiService{


            return Retrofit.Builder()
                .baseUrl("https://b2cstage2.mytv.vn/v8/") // Replace with your API base URL
                .client(
                    OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    })
                    .build())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}