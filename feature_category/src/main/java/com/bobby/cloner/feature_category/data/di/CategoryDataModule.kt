package com.bobby.cloner.feature_category.data.di

import androidx.room.Room
import com.bobby.cloner.feature_category.data.CategoryRepositoryImpl
import com.bobby.cloner.feature_category.data.database.LocalDataSource
import com.bobby.cloner.feature_category.data.database.room.CategoryDatabase
import com.bobby.cloner.feature_category.data.network.RemoteDataSource
import com.bobby.cloner.feature_category.data.network.service.CategoryService
import com.bobby.cloner.feature_category.domain.repository.CategoryRepository
import com.bobby.cloner.utils.Constants.CATEGORY_DB_NAME
import com.bobby.cloner.utils.Constants.YELP_RETROFIT
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val categoryDataModule = module {
    single<CategoryRepository> {
        CategoryRepositoryImpl(get(), get())
    }

    single<CategoryService> {
        get<Retrofit>(named(YELP_RETROFIT)).create(CategoryService::class.java)
    }

    single {
        LocalDataSource(get())
    }

    single {
        RemoteDataSource(get())
    }

    factory { get<CategoryDatabase>().categoryDao() }
    single {
        Room.databaseBuilder(androidContext(), CategoryDatabase::class.java, CATEGORY_DB_NAME)
            .fallbackToDestructiveMigration().build()
    }
}
