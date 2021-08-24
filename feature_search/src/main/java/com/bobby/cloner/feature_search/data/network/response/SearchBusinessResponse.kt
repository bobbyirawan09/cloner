package com.bobby.cloner.feature_search.data.network.response

import com.google.gson.annotations.SerializedName


data class SearchBusinessResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("text")
    val text: String? = null
)
