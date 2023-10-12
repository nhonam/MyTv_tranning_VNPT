package com.example.android.marsphotos.util

interface ApiResponseCallback<T> {
    fun onSuccess(response: T)
    fun onError(error: Throwable?)
}
