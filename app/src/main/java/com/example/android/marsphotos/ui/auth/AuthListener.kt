package com.example.android.marsphotos.ui.auth

import com.example.android.marsphotos.data.db.entities.User

interface AuthListener {

    fun onStarted()
    fun onSuccess(user:User)
    fun onFailure(message:String)
}