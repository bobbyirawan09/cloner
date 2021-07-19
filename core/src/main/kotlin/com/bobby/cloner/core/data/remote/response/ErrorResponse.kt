package com.bobby.cloner.core.data.remote.response

import com.google.gson.annotations.SerializedName

data class YelpErrorResponse(
    @SerializedName("code") val code: String,
    @SerializedName("description") val description: String,
    @SerializedName("new_business_id") val newBusinessId: String,
)
