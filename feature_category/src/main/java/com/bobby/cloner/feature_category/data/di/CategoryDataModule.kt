package com.bobby.cloner.feature_category.data

import com.bobby.cloner.feature_category.domain.CategoryRepository
import org.koin.dsl.module

val dataModule = module {
    single<CategoryRepository> {
        CategoryRepositoryImpl(get())
    }
}
