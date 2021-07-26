package com.bobby.cloner.feature_category.data.database.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bobby.cloner.feature_category.data.database.model.CategoryEntity

@Database(entities = [CategoryEntity::class], version = 1)
abstract class CategoryDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
}
