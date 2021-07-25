package com.bobby.cloner.core.data

import com.bobby.cloner.core.data.remote.response.ApiResponse
import kotlinx.coroutines.flow.*

abstract class NetworkBoundResource<ResultType, RequestType> {

    private var result: Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
//        val dbSource = loadFromDB().first()
//        if (shouldFetch(dbSource)) {
            emit(Resource.Loading())
            when (val apiResponse = createCall().first()) {
                is ApiResponse.Success -> {
                    saveCallResult(apiResponse.data)
                    if (shouldLoadFromDB()) {
//                        emitAll(loadFromDB().map {
//                            Resource.Success(it)
//                        })
                    } else {
                        val result = returnMappedCallResult(apiResponse.data)
                        Resource.Success(result)
                    }
                }
                is ApiResponse.Empty -> {
                    if (shouldLoadFromDB()) {
//                        emitAll(loadFromDB().map {
//                            Resource.Success(it)
//                        })
                    } else {
                        val result = returnMappedCallResult(null)
                        emit(Resource.SuccessButEmpty(result))
                    }
                }
                is ApiResponse.Error -> {
                    onFetchFailed()
                    emit(Resource.Error<ResultType>(apiResponse.errorMessage))
                }
            }
//        } else {
//            emitAll(loadFromDB().map {
//                Resource.Success(it)
//            })
//        }
    }

    protected open fun onFetchFailed() {}

//    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract fun shouldLoadFromDB(): Boolean

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>

    protected open suspend fun saveCallResult(data: RequestType) {}

    protected abstract suspend fun returnMappedCallResult(data: RequestType?): ResultType

    fun asFlow(): Flow<Resource<ResultType>> = result
}
