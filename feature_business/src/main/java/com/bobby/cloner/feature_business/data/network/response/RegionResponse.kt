package com.bobby.cloner.feature_business.data.network.response


import com.google.gson.annotations.SerializedName

data class RegionResponse(
    @SerializedName("center")
    val center: CenterResponse? = null
)
