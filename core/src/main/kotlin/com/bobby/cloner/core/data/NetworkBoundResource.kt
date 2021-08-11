package com.bobby.cloner.core.data

import com.bobby.cloner.core.data.remote.response.ApiResponse
import com.bobby.cloner.core.domain.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

abstract class NetworkBoundResource<ResultType, RequestType> {

    private var result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        when (val apiResponse = createCall().first()) {
            is ApiResponse.Success -> {
                val mapResult = mapResponseToDomain(apiResponse.data)
                emit(Resource.Success(mapResult))
            }
            is ApiResponse.Empty -> {
                emit(Resource.SuccessButEmpty<ResultType>(null))
            }
            is ApiResponse.Error -> {
                onFetchFailed()
                emit(Resource.Error<ResultType>(apiResponse.errorMessage))
            }
        }
    }

    protected open fun onFetchFailed() {}

    protected abstract fun mapResponseToDomain(response: RequestType): ResultType

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    fun asFlow(): Flow<Resource<ResultType>> = result
}
