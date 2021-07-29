package com.bobby.cloner.feature_business.domain.model

/**
 * Created by Bobby Irawan on 29/07/21.
 */
data class Business(
    val rating: Double,
    val phone: String,
    val id: String,
    val isClosed: Boolean,
    val category: List<BusinessCategory>,
    val reviewCount: Int,
    val name: String,
    val imageUrl: String,
    val displayAddress: String,
    val distance: Double
)
