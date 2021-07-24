package com.bobby.cloner.feature_category.data.network.service

import com.bobby.cloner.feature_category.data.network.response.CategoriesResponse
import retrofit2.Response
import retrofit2.http.GET

interface CategoryService {
    @GET("/categories")
    suspend fun getCategories(): Response<CategoriesResponse>
}
