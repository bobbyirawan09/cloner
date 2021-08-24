package com.bobby.cloner.feature_search.domain.usecase

import com.bobby.cloner.core.domain.Resource
import com.bobby.cloner.feature_search.domain.model.AutocompleteSuggestion
import com.bobby.cloner.feature_search.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

class GetYelpSuggestionUseCase(private val repository: SearchRepository) {
    fun getAutocompleteSuggestion(query: String): Flow<Resource<AutocompleteSuggestion>> =
        repository.getAutocompleteSuggestion(query)
}
