package com.bobby.cloner.feature_search.data.network.service

import com.bobby.cloner.feature_search.data.network.response.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET("autocomplete")
    suspend fun getAutocompleteSuggestion(
        @Query("text") query: String
    ): Response<SearchResponse>
}
