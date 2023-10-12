package com.example.android.marsphotos.ui.television.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.marsphotos.data.db.entities.Channel
import com.example.android.marsphotos.data.repository.SlideRepository
import com.example.android.marsphotos.util.ApiExceptions
import com.example.android.marsphotos.util.Coroutines
import com.google.gson.JsonArray
import com.google.gson.JsonObject

class TelevisionViewModel :ViewModel(){

    private val channels: MutableLiveData<List<Channel>> by lazy {
        MutableLiveData<List<Channel>>().also {
            loadChannels()
        }
    }
    fun addChanel(channel: Channel) {
        val currentSlides = channels.value?.toMutableList() ?: mutableListOf()
        currentSlides.add(channel)
        channels.value = currentSlides
    }


    fun getChannels(): LiveData<List<Channel>> {
        return channels
    }

    private fun loadChannels() {
        val params = HashMap<String, String>();
        params["device_model"] = "sdk_google_atv64_amati_arm64"
        params["fk"] = "first#key"
        params["session"] =
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0eXBlIjowLCJpcCI6IjE0LjIyNS4xMS4xMzAiLCJtYW51ZmFjdHVyZXJfaWQiOiI3MDQ2ZmM4NmYwMTBjYmExIiwiZXhwaXJlIjo0ODQ5MDAzMjU5LCJib2R5IjoiQjJDLS1ITkktLTgyODU5My0tNzA0NmZjODZmMDEwY2JhMSJ9.LBbCBK-BB54EwbngOk4D-R0ANNlyuhyundAvy5vKh8M"
        params["device_type"] = "9"
        params["version_number"] = "470"
        params["username_mytv"] = "tsna90"
        params["product_id"] = "57"
        params["member_id"] = "828593"
        params["manufacturer_id"] = "7046fc86f010cba1"
        params["device_manu"] = "Google"
        params["profile_type"] = "1"
        params["area_code"] = "HNI"
        params["user_team_id"] = "235"
        params["check_session"] = "1"
        params["ver_menu"] = "5"
        params["profile_id"] = "828593"
        params["username"] = "tsna90"

        // Do an asynchronous operation to fetch users.
        Coroutines.main {
            try {
                val response = SlideRepository().getImageList(params)
                var tmp: JsonObject? = null
                val data: JsonObject = response.getAsJsonObject("data")
                val service: JsonArray = data.getAsJsonArray("service")
                val trailer: JsonObject = data.getAsJsonObject("trailer")
                val listEvent: JsonArray = trailer.getAsJsonArray("data")

                //add item for list liveEvent
                listEvent.map { element ->

                    element as JsonObject?
                    val channel = Channel(
                        content_id = element.get("CONTENT_ID").toString(),
                        content_title = element.get("CONTENT_TITLE").toString(),
                        content_image_url = element.get("CONTENT_IMAGE_URL").toString()
                    )
                    addChanel(channel)
                }

            } catch (e: ApiExceptions) {

            }
        }
    }



}