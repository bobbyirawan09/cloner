package com.bobby.cloner.feature_category.data

import com.bobby.cloner.core.data.NetworkLocalBoundResource
import com.bobby.cloner.core.data.remote.response.ApiResponse
import com.bobby.cloner.core.domain.Resource
import com.bobby.cloner.feature_category.data.database.LocalDataSource
import com.bobby.cloner.feature_category.data.network.RemoteDataSource
import com.bobby.cloner.feature_category.data.network.response.CategoriesResponse
import com.bobby.cloner.feature_category.data.utils.DataMapper
import com.bobby.cloner.feature_category.domain.model.Category
import com.bobby.cloner.feature_category.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CategoryRepositoryImpl(val localDataSource: LocalDataSource, val remoteDataSource: RemoteDataSource) : CategoryRepository {
    override suspend fun getCategories(): Flow<Resource<List<Category>>> =
        object : NetworkLocalBoundResource<List<Category>, CategoriesResponse>() {
            override fun shouldFetch(data: List<Category>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<CategoriesResponse>> =
                remoteDataSource.getCategories()

            override suspend fun saveCallResult(data: CategoriesResponse) {
                val categoryList = data.categories?.map {
                    DataMapper.mapResponseToEntities(it)
                }.orEmpty()
                localDataSource.insertCategories(categoryList)
            }

            override fun loadFromDB(): Flow<List<Category>> {
                return localDataSource.getAllCategory().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

        }.asFlow()
}
