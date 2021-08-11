package com.bobby.cloner.feature_business.data

import com.bobby.cloner.core.data.NetworkBoundResource
import com.bobby.cloner.core.data.remote.response.ApiResponse
import com.bobby.cloner.core.domain.Resource
import com.bobby.cloner.feature_business.data.network.RemoteDataSource
import com.bobby.cloner.feature_business.data.network.response.BusinessesResponse
import com.bobby.cloner.feature_business.domain.model.Business
import com.bobby.cloner.feature_business.domain.model.BusinessCategory
import com.bobby.cloner.feature_business.domain.repository.BusinessRepository
import com.bobby.cloner.utils.orFalse
import com.bobby.cloner.utils.orZero
import kotlinx.coroutines.flow.Flow

class BusinessRepositoryImpl(
    val remoteDataSource: RemoteDataSource
) : BusinessRepository {
    override fun getBusinesses(): Flow<Resource<List<Business>>> =
        object : NetworkBoundResource<List<Business>, BusinessesResponse>() {
            override fun mapResponseToDomain(response: BusinessesResponse): List<Business> =
                response.businesses?.map {
                    val categories = it?.categories?.map {
                        BusinessCategory(
                            it.alias.orEmpty(),
                            it.title.orEmpty()
                        )
                    }.orEmpty()
                    val displayAddress = it?.location?.displayAddress?.joinToString(", ").orEmpty()
                    val displayCategory = categories.joinToString(separator = ", ") {
                        it.title
                    }
                    val displayDistance = String.format("%.2f", it?.distance.orZero())
                    Business(
                        it?.rating.orZero(),
                        it?.phone.orEmpty(),
                        it?.id.orEmpty(),
                        it?.isClosed.orFalse(),
                        displayCategory,
                        it?.reviewCount.orZero().toString(),
                        it?.name.orEmpty(),
                        it?.imageUrl.orEmpty(),
                        displayAddress,
                        displayDistance
                    )
                }.orEmpty()

            override suspend fun createCall(): Flow<ApiResponse<BusinessesResponse>> =
                remoteDataSource.getBusiness()
        }.asFlow()
}
