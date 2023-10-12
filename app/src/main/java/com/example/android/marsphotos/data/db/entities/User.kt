package com.example.android.marsphotos.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.JsonElement

const val CURRENT_MEMBER_ID =0



data class User(
    var member_id: String? =null,
    var product_id:String? =null,
    var area_code:String? =null,
    var username_mytv:String? =null,
    var user_team_id:String? =null,
    var user_type:String? =null,
    var manufacturer_id:String? =null,
    var product_plugin:String? =null
) {

}