package com.bobby.cloner.feature_business.data.network

import com.bobby.cloner.core.data.remote.networkRequestHandling
import com.bobby.cloner.core.data.remote.response.ApiResponse
import com.bobby.cloner.feature_business.data.network.service.BusinessService
import kotlinx.coroutines.flow.Flow

class RemoteDataSource(val service: BusinessService) {
    suspend fun getCategories(): Flow<ApiResponse<CategoriesResponse>> = networkRequestHandling {
        service.getCategories()
    }
}
