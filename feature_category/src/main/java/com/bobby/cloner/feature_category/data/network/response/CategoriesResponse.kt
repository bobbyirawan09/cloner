package com.bobby.cloner.feature_category.data.network.response


import com.bobby.cloner.core.data.remote.response.YelpErrorResponse
import com.google.gson.annotations.SerializedName

data class CategoriesResponse(
    @SerializedName("categories")
    val categories: List<CategoryResponse>? = listOf(),
    @SerializedName("error")
    val error: YelpErrorResponse? = null
)
