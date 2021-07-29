package com.bobby.cloner.feature_business.data.network.response


import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("alias")
    val alias: String? = null,
    @SerializedName("title")
    val title: String? = null
)
