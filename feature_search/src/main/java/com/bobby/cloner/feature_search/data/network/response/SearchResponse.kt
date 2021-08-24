package com.bobby.cloner.feature_search.data.network.response

import com.google.gson.annotations.SerializedName


data class SearchResponse(
    @SerializedName("businesses")
    val businesses: List<SearchBusinessResponse>? = null,
    @SerializedName("categories")
    val categories: List<SearchCategoryResponse>? = null,
    @SerializedName("terms")
    val terms: List<SearchTermResponse>? = null
)
