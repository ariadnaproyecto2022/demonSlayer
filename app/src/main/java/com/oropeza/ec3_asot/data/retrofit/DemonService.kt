package com.oropeza.ec3_asot.data.retrofit

import com.oropeza.ec3_asot.data.response.DemonListResponse
import retrofit2.http.GET

interface DemonService {
    @GET("v1?limit=5")
    suspend fun getDemons(): DemonListResponse
}