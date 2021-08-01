package com.bobby.cloner.feature_business.data.di

import com.bobby.cloner.feature_business.data.BusinessPagingSource
import com.bobby.cloner.feature_business.data.BusinessRepositoryImpl
import com.bobby.cloner.feature_business.data.network.RemoteDataSource
import com.bobby.cloner.feature_business.data.network.service.BusinessService
import com.bobby.cloner.feature_business.domain.repository.BusinessRepository
import com.bobby.cloner.utils.Constants.YELP_RETROFIT
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val businessDataModule = module {
    single<BusinessRepository> {
        BusinessRepositoryImpl(get(), get())
    }

    single<BusinessService> {
        get<Retrofit>(named(YELP_RETROFIT)).create(BusinessService::class.java)
    }

    single {
        RemoteDataSource(get())
    }

    single {
        BusinessPagingSource(get())
    }
}
