package com.bobby.cloner.feature_business.data.network.response


import com.google.gson.annotations.SerializedName

data class OpenResponse(
    @SerializedName("day")
    val day: Int? = null,
    @SerializedName("end")
    val end: String? = null,
    @SerializedName("is_overnight")
    val isOvernight: Boolean? = null,
    @SerializedName("start")
    val start: String? = null
)
