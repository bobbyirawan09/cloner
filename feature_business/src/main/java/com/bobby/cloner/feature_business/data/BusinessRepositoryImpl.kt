package com.bobby.cloner.feature_business.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.bobby.cloner.feature_business.data.network.RemoteDataSource
import com.bobby.cloner.feature_business.domain.model.Business
import com.bobby.cloner.feature_business.domain.repository.BusinessRepository
import com.bobby.cloner.utils.Constants.NETWORK_PAGE_SIZE
import kotlinx.coroutines.flow.Flow

class BusinessRepositoryImpl(
    val businessPagingSource: BusinessPagingSource,
    val remoteDataSource: RemoteDataSource
) : BusinessRepository {
    override suspend fun getBusinesses(): Flow<PagingData<Business>> {
        return Pager(
            config = PagingConfig(
                pageSize = NETWORK_PAGE_SIZE,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                businessPagingSource
            }
        ).flow
    }
}
