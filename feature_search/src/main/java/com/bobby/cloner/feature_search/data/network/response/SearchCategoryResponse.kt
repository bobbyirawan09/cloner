package com.bobby.cloner.feature_search.data.network.response

import com.google.gson.annotations.SerializedName


data class SearchCategoryResponse(
    @SerializedName("alias")
    val alias: String? = null,
    @SerializedName("title")
    val title: String? = null
)
