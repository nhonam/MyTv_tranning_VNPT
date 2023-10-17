package com.example.android.marsphotos.data.network

import com.example.android.marsphotos.data.model.Home.ResponseHome
import com.example.android.marsphotos.data.model.Television.ResponseAllChannel
import com.example.android.marsphotos.data.model.Orther.UserInfo
import com.example.android.marsphotos.data.model.film.ResponseFilm
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
    suspend fun getInforHomeApi(@FieldMap map: HashMap<String, String>): ResponseHome

    @FormUrlEncoded
    @POST("channel/list-v3")
    suspend fun getChannels(@FieldMap map: HashMap<String, String>): ResponseAllChannel

    @FormUrlEncoded
    @POST("content/home")
    suspend fun getCategoryFilmAndFilmItem(@FieldMap map: HashMap<String, String>): ResponseFilm

    @FormUrlEncoded
    @POST("account/info-v5")
    suspend fun getInfoAccount(@FieldMap map: HashMap<String, String>): UserInfo




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