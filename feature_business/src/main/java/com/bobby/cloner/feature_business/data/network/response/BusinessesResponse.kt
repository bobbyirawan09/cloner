package com.bobby.cloner.feature_business.data.network.response


import com.google.gson.annotations.SerializedName

data class BusinessesResponse(
    @SerializedName("businesses")
    val businesses: List<BusinessResponse>? = null,
    @SerializedName("region")
    val region: RegionResponse? = null,
    @SerializedName("total")
    val total: Int? = null
)
