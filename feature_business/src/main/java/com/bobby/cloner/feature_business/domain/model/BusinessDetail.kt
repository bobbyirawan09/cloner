package com.bobby.cloner.feature_business.domain.model

data class BusinessDetail(
    val rating: Double,
    val phone: String,
    val category: String,
    val reviewCount: String,
    val name: String,
    val imageUrl: String,
    val imageBusiness: List<String>,
    val address: String,
    val coordinates: Coordinates,
    val openDays: List<OpenDay>,
    val price: String
)
