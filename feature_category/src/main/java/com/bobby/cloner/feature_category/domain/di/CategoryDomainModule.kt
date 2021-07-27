package com.bobby.cloner.feature_category.domain.di

import com.bobby.cloner.feature_category.domain.usecase.GetCategoryUseCase
import org.koin.dsl.module

val categoryDomainModule = module {
    single {
        GetCategoryUseCase(get())
    }
}
