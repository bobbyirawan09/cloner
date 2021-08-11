package com.bobby.cloner.feature_business.data.network.response


import com.google.gson.annotations.SerializedName

data class SpecialHourResponse(
    @SerializedName("date")
    val date: String? = null,
    @SerializedName("end")
    val end: String? = null,
    @SerializedName("is_closed")
    val isClosed: Boolean? = null,
    @SerializedName("is_overnight")
    val isOvernight: Boolean? = null,
    @SerializedName("start")
    val start: String? = null
)
