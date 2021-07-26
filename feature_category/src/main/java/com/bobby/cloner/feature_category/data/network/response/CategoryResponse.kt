package com.bobby.cloner.feature_category.data.network.response


import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("alias")
    val alias: String? = "",
    @SerializedName("country_blacklist")
    val countryBlacklist: List<Any>? = listOf(),
    @SerializedName("country_whitelist")
    val countryWhitelist: List<String>? = listOf(),
    @SerializedName("parent_aliases")
    val parentAliases: List<String>? = listOf(),
    @SerializedName("title")
    val title: String? = ""
)
