package com.bobby.cloner.feature_business.domain.di

import com.bobby.cloner.feature_business.domain.usecase.GetBusinessUseCase
import org.koin.dsl.module

val categoryDomainModule = module {
    single {
        GetBusinessUseCase(get())
    }
}
