package com.bobby.cloner.feature_business.data.network.response


import com.google.gson.annotations.SerializedName

data class BusinessDetailResponse(
    @SerializedName("alias")
    val alias: String? = null,
    @SerializedName("categories")
    val categories: List<CategoryResponse>? = null,
    @SerializedName("coordinates")
    val coordinates: CoordinatesResponse? = CoordinatesResponse(),
    @SerializedName("display_phone")
    val displayPhone: String? = null,
    @SerializedName("hours")
    val hours: List<HourResponse>? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("image_url")
    val imageUrl: String? = null,
    @SerializedName("is_claimed")
    val isClaimed: Boolean? = null,
    @SerializedName("is_closed")
    val isClosed: Boolean? = null,
    @SerializedName("location")
    val location: LocationResponse? = LocationResponse(),
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("photos")
    val photos: List<String>? = null,
    @SerializedName("price")
    val price: String? = null,
    @SerializedName("rating")
    val rating: Double? = null,
    @SerializedName("review_count")
    val reviewCount: Int? = null,
    @SerializedName("special_hours")
    val specialHours: List<SpecialHourResponse>? = null,
    @SerializedName("transactions")
    val transactions: List<Any>? = null,
    @SerializedName("url")
    val url: String? = null
)
