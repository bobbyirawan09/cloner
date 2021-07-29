package com.bobby.cloner.feature_business.domain.repository

import androidx.paging.PagingData
import com.bobby.cloner.feature_business.domain.model.Business
import kotlinx.coroutines.flow.Flow

interface BusinessRepository {
    suspend fun getBusinesses(): Flow<PagingData<Business>>
}
