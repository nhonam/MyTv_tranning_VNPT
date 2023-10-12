package com.example.android.marsphotos.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android.marsphotos.data.db.entities.LiveEvent
import com.example.android.marsphotos.data.db.entities.Slide
import com.example.android.marsphotos.data.repository.SlideRepository
import com.example.android.marsphotos.util.ApiExceptions
import com.example.android.marsphotos.util.Coroutines
import com.google.gson.JsonArray
import com.google.gson.JsonObject

class HomeViewModel : ViewModel() {


    private val slides: MutableLiveData<List<Slide>> by lazy {
        MutableLiveData<List<Slide>>().also {
            loadSlides()
        }
    }

    private val liveEvents: MutableLiveData<List<LiveEvent>> by lazy {
        MutableLiveData<List<LiveEvent>>().also {
            loadSlides()
        }
    }

    fun getSlides(): LiveData<List<Slide>> {
        return slides
    }

    fun getLiveEvents(): LiveData<List<LiveEvent>> {
        return liveEvents
    }

    fun addliveEvents(liveEvent: LiveEvent) {
        val currentSlides = liveEvents.value?.toMutableList() ?: mutableListOf()
        currentSlides.add(liveEvent)
        liveEvents.value = currentSlides
    }

    fun addSlide(slide: Slide) {
        val currentSlides = slides.value?.toMutableList() ?: mutableListOf()
        currentSlides.add(slide)
        slides.value = currentSlides
    }

    private fun loadSlides() {

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
        params["ver_app_show"] = "14"
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
                    val liveEvent = LiveEvent(
                        content_id = element.get("CONTENT_ID").toString(),
                        content_title = element.get("CONTENT_TITLE").toString(),
                        content_image_url = element.get("CONTENT_IMAGE_URL").toString()
                    )
                    addliveEvents(liveEvent)
                }

                //add item form repository for slides
                service.map { element ->

                    element as JsonObject?
                    val slide = Slide(
                        id = element.get("id").toString(),
                        logo = element.get("logo").toString(),
                        title = element.get("title").toString()
                    )
                    addSlide(slide)

                }

            } catch (e: ApiExceptions) {

            }
        }

    }

}