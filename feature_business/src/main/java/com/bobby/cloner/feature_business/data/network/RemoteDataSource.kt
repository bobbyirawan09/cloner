package com.bobby.cloner.feature_business.data.network

import com.bobby.cloner.core.data.remote.networkRequestHandling
import com.bobby.cloner.feature_business.data.network.service.BusinessService

class RemoteDataSource(private val service: BusinessService) {
    suspend fun getBusiness() =
        networkRequestHandling {
            service.getBusiness(0, 10)
        }

    suspend fun getBusinessDetails(id: String) = networkRequestHandling {
        service.getBusinessDetail(id)
    }
}
