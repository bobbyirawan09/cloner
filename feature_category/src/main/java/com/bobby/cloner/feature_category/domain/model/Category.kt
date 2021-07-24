package com.bobby.cloner.feature_category.domain.model

data class Category(
    val alias: String,
    val parentAliases: List<Any>,
    val title: String
)
