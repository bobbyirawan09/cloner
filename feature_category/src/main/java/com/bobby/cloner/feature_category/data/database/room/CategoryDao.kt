package com.bobby.cloner.feature_category.data.database.room

import androidx.room.*
import com.bobby.cloner.feature_category.data.database.model.CategoryEntity
import com.bobby.cloner.utils.Constants.CATEGORY_TABLE_NAME
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {

    @Query("SELECT * FROM $CATEGORY_TABLE_NAME")
    fun getAllCategory(): Flow<List<CategoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(entity: CategoryEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategories(entities: List<CategoryEntity>)

    @Delete
    fun deleteCategory(category: CategoryEntity)
}
