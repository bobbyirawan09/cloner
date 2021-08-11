package com.bobby.cloner.feature_business.domain.repository

import com.bobby.cloner.core.domain.Resource
import com.bobby.cloner.feature_business.domain.model.Business
import kotlinx.coroutines.flow.Flow

interface BusinessRepository {
    fun getBusinesses(): Flow<Resource<List<Business>>>
}
