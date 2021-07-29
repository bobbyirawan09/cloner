package com.bobby.cloner.feature_business.data.network.response


import com.google.gson.annotations.SerializedName

data class CoordinatesResponse(
    @SerializedName("latitude")
    val latitude: Double? = null,
    @SerializedName("longitude")
    val longitude: Double? = null
)
