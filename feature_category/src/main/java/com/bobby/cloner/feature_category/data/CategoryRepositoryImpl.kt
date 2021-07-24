package com.bobby.cloner.feature_category.data

import com.bobby.cloner.core.data.Resource
import com.bobby.cloner.feature_category.data.network.RemoteDataSource
import com.bobby.cloner.feature_category.data.utils.DataMapper
import com.bobby.cloner.feature_category.domain.repository.CategoryRepository
import com.bobby.cloner.feature_category.domain.model.Category
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CategoryRepositoryImpl(val remoteDataSource: RemoteDataSource): CategoryRepository {
    override suspend fun getCategories(): Flow<Resource<Category>> {
        return remoteDataSource.getCategories().map {
            DataMapper.mapResponseToEntities()
        }
    }
}
