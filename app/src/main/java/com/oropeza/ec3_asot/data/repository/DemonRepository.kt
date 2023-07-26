package com.oropeza.ec3_asot.data.repository

import com.oropeza.ec3_asot.data.response.ApiResponse
import com.oropeza.ec3_asot.data.response.DemonListResponse
import com.oropeza.ec3_asot.data.retrofit.ServiceInstance

class DemonRepository {
    suspend fun getDemons(): ApiResponse<DemonListResponse> {
        return try {
            val response = ServiceInstance.getDemonService().getDemons()
            ApiResponse.Success(response)
        } catch (e: Exception) {
            ApiResponse.Error(e)
        }
    }
}