package com.bobby.cloner.feature_category.data.network

import com.bobby.cloner.feature_category.data.network.response.CategoriesResponse
import retrofit2.http.GET

interface CategoryService {
    @GET("/categories")
    fun getCategories(): CategoriesResponse
}
