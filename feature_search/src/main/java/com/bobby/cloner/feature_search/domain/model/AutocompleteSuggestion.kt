package com.bobby.cloner.feature_search.domain.model

/**
 * Created by Bobby Irawan on 24/08/21.
 */
data class AutocompleteSuggestion(
    val business: List<BusinessSuggestion>,
    val category: List<CategorySuggestion>
)
