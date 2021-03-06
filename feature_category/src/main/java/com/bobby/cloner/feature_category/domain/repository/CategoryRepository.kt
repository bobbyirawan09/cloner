package com.bobby.cloner.feature_category.domain.repository

import com.bobby.cloner.core.domain.Resource
import com.bobby.cloner.feature_category.domain.model.Category
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun getCategories(): Flow<Resource<List<Category>>>
}
