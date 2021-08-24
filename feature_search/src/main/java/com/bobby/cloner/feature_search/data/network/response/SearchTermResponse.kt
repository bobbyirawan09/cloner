package com.bobby.cloner.feature_search.data.network.response

import com.google.gson.annotations.SerializedName

data class SearchTermResponse(
    @SerializedName("text")
    val text: String? = null
)
