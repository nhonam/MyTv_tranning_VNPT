package com.example.android.marsphotos.util

import okio.IOException

class ApiExceptions(message : String) :IOException(message)
class NoInternetExceptions(message : String) :IOException(message)