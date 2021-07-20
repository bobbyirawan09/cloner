package com.bobby.cloner.feature_category.data

import com.bobby.cloner.feature_category.data.network.CategoryService
import com.bobby.cloner.feature_category.domain.CategoryRepository

class CategoryRepositoryImpl(val service: CategoryService): CategoryRepository {
    override fun getCategories() {
        service.getCategories()
    }
}
