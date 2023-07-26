package com.oropeza.ec3_asot.data.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceInstance {
    // https://demon-slayer-api.onrender.com/v1?limit=10
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://demon-slayer-api.onrender.com/")
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun getDemonService(): DemonService = retrofit.create(DemonService::class.java)
}