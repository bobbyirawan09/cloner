package com.bobby.cloner.feature_category.data.database

import com.bobby.cloner.feature_category.data.database.model.CategoryEntity
import com.bobby.cloner.feature_category.data.database.room.CategoryDao

class LocalDataSource(private val dao: CategoryDao) {
    fun getAllCategory() = dao.getAllCategory()

    suspend fun insertCategory(entity: CategoryEntity) = dao.insertCategory(entity)

    suspend fun insertCategories(entities: List<CategoryEntity>) = dao.insertCategories(entities)

    fun deleteCategory(entity: CategoryEntity) = dao.deleteCategory(entity)
}
