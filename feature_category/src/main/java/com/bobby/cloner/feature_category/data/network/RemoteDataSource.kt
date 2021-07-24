package com.bobby.cloner.feature_category.data.network

import com.bobby.cloner.core.data.remote.networkRequestHandling
import com.bobby.cloner.core.data.remote.response.ApiResponse
import com.bobby.cloner.feature_category.data.network.response.CategoriesResponse
import com.bobby.cloner.feature_category.data.network.service.CategoryService
import com.bobby.cloner.feature_category.domain.model.Category
import kotlinx.coroutines.flow.Flow

class RemoteDataSource(val service: CategoryService) {
    suspend fun getCategories(): Flow<ApiResponse<CategoriesResponse>> = networkRequestHandling{
        service.getCategories()
    }
}
