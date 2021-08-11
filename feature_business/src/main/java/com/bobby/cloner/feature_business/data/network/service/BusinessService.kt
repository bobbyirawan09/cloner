package com.bobby.cloner.feature_business.data.network.service

import com.bobby.cloner.feature_business.data.network.response.BusinessesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface BusinessService {
    @GET("businesses/search?location=Johor%20Bahru&categories=restaurants")
    suspend fun getBusiness(
        @Query("offset") start: Int,
        @Query("limit") limit: Int
    ): Response<BusinessesResponse>
}
