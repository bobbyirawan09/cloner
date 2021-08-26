package com.bobby.cloner.feature_search.data.di

import com.bobby.cloner.feature_search.data.SearchRepositoryImpl
import com.bobby.cloner.feature_search.data.network.RemoteDataSource
import com.bobby.cloner.feature_search.data.network.service.SearchService
import com.bobby.cloner.feature_search.domain.repository.SearchRepository
import com.bobby.cloner.utils.Constants.YELP_RETROFIT
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val searchDataModule = module {
    single<SearchRepository> {
        SearchRepositoryImpl(get())
    }

    single<SearchService> {
        get<Retrofit>(named(YELP_RETROFIT)).create(SearchService::class.java)
    }

    single {
        RemoteDataSource(get())
    }

//    single {
//        BusinessPagingSource(get())
//    }
}
