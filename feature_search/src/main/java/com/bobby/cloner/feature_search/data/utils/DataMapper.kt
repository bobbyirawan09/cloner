package com.bobby.cloner.feature_search.data.utils

import com.bobby.cloner.feature_search.data.network.response.SearchBusinessResponse
import com.bobby.cloner.feature_search.data.network.response.SearchCategoryResponse
import com.bobby.cloner.feature_search.data.network.response.SearchResponse
import com.bobby.cloner.feature_search.domain.model.AutocompleteSuggestion
import com.bobby.cloner.feature_search.domain.model.BusinessSuggestion
import com.bobby.cloner.feature_search.domain.model.CategorySuggestion

object DataMapper {

    fun mapResponseToDomain(response: SearchResponse?): AutocompleteSuggestion {
        val business = response?.businesses?.map {
            mapResponseToDomain(it)
        }.orEmpty()

        val category = response?.categories?.map {
            mapResponseToDomain(it)
        }.orEmpty()

        return AutocompleteSuggestion(
            business,
            category
        )
    }

    fun mapResponseToDomain(response: SearchBusinessResponse?) = BusinessSuggestion(
        response?.name.orEmpty(),
        response?.id.orEmpty()
    )

    fun mapResponseToDomain(response: SearchCategoryResponse?) = CategorySuggestion(
        response?.alias.orEmpty(),
        response?.title.orEmpty()
    )
}
