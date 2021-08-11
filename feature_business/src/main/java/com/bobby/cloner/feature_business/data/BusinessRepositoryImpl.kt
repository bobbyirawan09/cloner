package com.bobby.cloner.feature_business.data

import com.bobby.cloner.core.data.NetworkBoundResource
import com.bobby.cloner.core.data.remote.response.ApiResponse
import com.bobby.cloner.core.domain.Resource
import com.bobby.cloner.feature_business.data.network.RemoteDataSource
import com.bobby.cloner.feature_business.data.network.response.BusinessDetailResponse
import com.bobby.cloner.feature_business.data.network.response.BusinessesResponse
import com.bobby.cloner.feature_business.data.utils.DataMapper
import com.bobby.cloner.feature_business.domain.model.Business
import com.bobby.cloner.feature_business.domain.model.BusinessDetail
import com.bobby.cloner.feature_business.domain.repository.BusinessRepository
import kotlinx.coroutines.flow.Flow

class BusinessRepositoryImpl(
    val remoteDataSource: RemoteDataSource
) : BusinessRepository {
    override fun getBusinesses(): Flow<Resource<List<Business>>> =
        object : NetworkBoundResource<List<Business>, BusinessesResponse>() {
            override fun mapResponseToDomain(response: BusinessesResponse): List<Business> =
                response.businesses?.map {
                    DataMapper.mapResponseToDomain(it)
                }.orEmpty()

            override suspend fun createCall(): Flow<ApiResponse<BusinessesResponse>> =
                remoteDataSource.getBusiness()
        }.asFlow()

    override fun getBusinessDetail(id: String): Flow<Resource<BusinessDetail>> =
        object : NetworkBoundResource<BusinessDetail, BusinessDetailResponse>() {
            override fun mapResponseToDomain(response: BusinessDetailResponse): BusinessDetail =
                DataMapper.mapResponseToDomain(response)

            override suspend fun createCall(): Flow<ApiResponse<BusinessDetailResponse>> =
                remoteDataSource.getBusinessDetails(id)
        }.asFlow()
}
