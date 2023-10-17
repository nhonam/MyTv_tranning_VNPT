package com.example.android.marsphotos.ui.film

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.marsphotos.data.model.film.Data
import com.example.android.marsphotos.data.repository.FilmRepository
import com.example.android.marsphotos.util.ApiExceptions
import com.example.android.marsphotos.util.Coroutines

class FilmViewModel: ViewModel() {

    val dataList = MutableLiveData<Data>()
    fun getData(): LiveData<Data> {
        loadData()
        return dataList
    }


    private fun loadData() {

        val params = HashMap<String, String>();
        params["device_model"] = "sdk_google_atv64_amati_arm64"
        params["fk"] = "first#key"
        params["session"] ="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0eXBlIjowLCJpcCI6IjEwNC4yOC4yMDUuNzIiLCJtYW51ZmFjdHVyZXJfaWQiOiI3MDQ2ZmM4NmYwMTBjYmExIiwiZXhwaXJlIjo0ODUxMDIxMzQ2LCJib2R5IjoiQjJDLS1ITkktLTgyODU5My0tNzA0NmZjODZmMDEwY2JhMSJ9.TWgBo0a1p28a2egsjnqcgKFjMmpa6tXM_Ou6N9RVDFI"
        params["device_type"] = "9"
        params["language"] = "vi"
        params["version_number"] = "470"
        params["username_mytv"] = "tsna90"
        params["password"] = "c4ca4238a0b923820dcc509a6f75849b"
        params["user_type"] = "2"
        params["param_api"] = "module_service_id%3D2012"
        params["product_id"] = "57"
        params["member_id"] = "828593"
        params["ver"] = "0"
        params["manufacturer_id"] = "7046fc86f010cba1"
        params["device_manu"] = "Google"
        params["profile_type"] = "1"
        params["type_id"] = "2"
        params["area_code"] = "HNI"
        params["register_info_register_trial"] = "0"
        params["user_team_id"] = "235"
        params["check_session"] = "1"
        params["api_ver"] = "0"
        params["register_info_type_member"] = "0"
        params["module_id"] = "2012"
        params["username"] = "tsna90"



        // Do an asynchronous operation to fetch users.
        Coroutines.main {
            try {
                val response = FilmRepository().getCategoryFilmAndFilmItem(params)
                println(response)
//                dataList.postValue(response.data)


            } catch (e: ApiExceptions) {
                println(e.message)
            }
        }
    }
}