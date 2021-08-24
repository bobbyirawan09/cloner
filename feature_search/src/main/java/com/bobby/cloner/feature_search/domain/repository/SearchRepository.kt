package com.bobby.cloner.feature_search.domain.repository

import com.bobby.cloner.core.domain.Resource
import com.bobby.cloner.feature_search.domain.model.AutocompleteSuggestion
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    fun getAutocompleteSuggestion(query: String): Flow<Resource<AutocompleteSuggestion>>
}
