package com.bobby.cloner.feature_business.domain.di

import com.bobby.cloner.feature_business.domain.usecase.GetBusinessDetailsUseCase
import com.bobby.cloner.feature_business.domain.usecase.GetBusinessUseCase
import org.koin.dsl.module

val businessDomainModule = module {
    single {
        GetBusinessUseCase(get())
    }
    single {
        GetBusinessDetailsUseCase(get())
    }
}
