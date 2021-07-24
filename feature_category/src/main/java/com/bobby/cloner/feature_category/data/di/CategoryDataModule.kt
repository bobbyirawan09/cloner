package com.bobby.cloner.feature_category.data.di

import com.bobby.cloner.feature_category.data.CategoryRepositoryImpl
import com.bobby.cloner.feature_category.data.network.service.CategoryService
import com.bobby.cloner.feature_category.domain.repository.CategoryRepository
import com.bobby.cloner.utils.Constants.YELP_RETROFIT
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val categoryDataModule = module {
    single<CategoryRepository> {
        CategoryRepositoryImpl(get())
    }

    single<CategoryService> {
        get<Retrofit>(named(YELP_RETROFIT)).create(CategoryService::class.java)
    }
}
