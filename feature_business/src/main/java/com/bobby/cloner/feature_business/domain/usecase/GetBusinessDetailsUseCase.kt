package com.bobby.cloner.feature_business.domain.usecase

import com.bobby.cloner.feature_business.domain.repository.BusinessRepository

class GetBusinessDetailsUseCase(private val repository: BusinessRepository) {
    fun getBusinessDetail(id: String) = repository.getBusinessDetail(id)
}
