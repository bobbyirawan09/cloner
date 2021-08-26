package com.bobby.cloner.feature_search.data

import com.bobby.cloner.core.data.NetworkBoundResource
import com.bobby.cloner.core.data.remote.response.ApiResponse
import com.bobby.cloner.core.domain.Resource
import com.bobby.cloner.feature_search.data.network.RemoteDataSource
import com.bobby.cloner.feature_search.data.network.response.SearchResponse
import com.bobby.cloner.feature_search.data.utils.DataMapper
import com.bobby.cloner.feature_search.domain.model.AutocompleteSuggestion
import com.bobby.cloner.feature_search.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow

class SearchRepositoryImpl(
    val remoteDataSource: RemoteDataSource
) : SearchRepository {
    override fun getAutocompleteSuggestion(query: String): Flow<Resource<List<AutocompleteSuggestion>>> =
        object : NetworkBoundResource<List<AutocompleteSuggestion>, SearchResponse>() {
            override fun mapResponseToDomain(response: SearchResponse): List<AutocompleteSuggestion> =
                DataMapper.mapResponseToDomain(response)

            override suspend fun createCall(): Flow<ApiResponse<SearchResponse>> =
                remoteDataSource.getAutocompleteSuggestion(query)
        }.asFlow()
}
