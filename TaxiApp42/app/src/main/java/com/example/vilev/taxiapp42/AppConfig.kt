package com.example.vilev.taxiapp42

import okhttp3.OkHttpClient

/**
 * Created by vilev on 12.04.2017.
 */
class AppConfig {
    companion object
    {
        val client = OkHttpClient.Builder().build()
        val url = "http://89.223.29.6:8080/taxi/"
    }
}