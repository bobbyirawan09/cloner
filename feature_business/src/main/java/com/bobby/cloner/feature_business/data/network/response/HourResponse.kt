package com.bobby.cloner.feature_business.data.network.response


import com.google.gson.annotations.SerializedName

data class HourResponse(
    @SerializedName("hours_type")
    val hoursType: String? = null,
    @SerializedName("is_open_now")
    val isOpenNow: Boolean? = null,
    @SerializedName("open")
    val open: List<OpenResponse>? = null
)
