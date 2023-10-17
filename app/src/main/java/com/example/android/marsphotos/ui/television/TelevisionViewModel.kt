package com.example.android.marsphotos.ui.television

import android.content.SharedPreferences
import android.preference.PreferenceManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.marsphotos.data.model.Television.Channel
import com.example.android.marsphotos.data.repository.ChannelRepository
import com.example.android.marsphotos.util.ApiExceptions
import com.example.android.marsphotos.util.Coroutines

class TelevisionViewModel :ViewModel(){


    val movieList = MutableLiveData<List<Channel>>()

    fun getChannels(): LiveData<List<Channel>> {
        loadChannels()
        return movieList
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
        // Do an synchronous operation to fetch users.
        Coroutines.main {
            try {

                val response = ChannelRepository().getChannels(params)

                movieList.postValue(response.data)



            } catch (e: ApiExceptions) {

            }
        }
    }



}