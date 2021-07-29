package com.bobby.cloner.feature_business.domain.usecase

import androidx.paging.PagingData
import com.bobby.cloner.feature_business.domain.model.Business
import com.bobby.cloner.feature_business.domain.repository.BusinessRepository
import kotlinx.coroutines.flow.Flow

class GetBusinessUseCase(private val repository: BusinessRepository) {
    suspend fun getBusinesses(): Flow<PagingData<Business>> = repository.getBusinesses()
}
