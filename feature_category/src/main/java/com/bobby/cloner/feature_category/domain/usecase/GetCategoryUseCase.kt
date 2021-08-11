package com.bobby.cloner.feature_category.domain.usecase

import com.bobby.cloner.core.domain.BaseUseCase
import com.bobby.cloner.core.domain.Resource
import com.bobby.cloner.feature_category.domain.model.Category
import com.bobby.cloner.feature_category.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow

class GetCategoryUseCase(val repository: CategoryRepository): BaseUseCase<Flow<Resource<List<Category>>>>() {
    override suspend fun execute(): Flow<Resource<List<Category>>> = repository.getCategories()
}
