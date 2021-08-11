package com.bobby.cloner.feature_business.domain.usecase

import com.bobby.cloner.core.domain.Resource
import com.bobby.cloner.feature_business.domain.model.Business
import com.bobby.cloner.feature_business.domain.repository.BusinessRepository
import kotlinx.coroutines.flow.Flow

class GetBusinessUseCase(private val repository: BusinessRepository) {
    fun getBusinesses(): Flow<Resource<List<Business>>> = repository.getBusinesses()
}
