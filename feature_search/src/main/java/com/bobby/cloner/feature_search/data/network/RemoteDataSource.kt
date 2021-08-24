package com.bobby.cloner.feature_search.data.network

import com.bobby.cloner.core.data.remote.networkRequestHandling
import com.bobby.cloner.feature_search.data.network.service.SearchService

class RemoteDataSource(private val service: SearchService) {
    suspend fun getAutocompleteSuggestion(query: String) =
        networkRequestHandling {
            service.getAutocompleteSuggestion(query)
        }
}
