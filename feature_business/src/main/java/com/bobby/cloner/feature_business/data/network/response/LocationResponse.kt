package com.bobby.cloner.feature_business.data.network.response


import com.google.gson.annotations.SerializedName

data class LocationResponse(
    @SerializedName("address1")
    val firstAddress: String? = null,
    @SerializedName("address2")
    val secondAddress: String? = null,
    @SerializedName("address3")
    val thirdAddress: Any? = null,
    @SerializedName("city")
    val city: String? = null,
    @SerializedName("country")
    val country: String? = null,
    @SerializedName("display_address")
    val displayAddress: List<String>? = null,
    @SerializedName("state")
    val state: String? = null,
    @SerializedName("zip_code")
    val zipCode: String? = null
)
