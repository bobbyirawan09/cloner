package com.bobby.cloner.feature_category.data.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bobby.cloner.utils.Constants.CATEGORY_COLUMN_ALIAS
import com.bobby.cloner.utils.Constants.CATEGORY_COLUMN_ID
import com.bobby.cloner.utils.Constants.CATEGORY_COLUMN_PARENT_ALIAS
import com.bobby.cloner.utils.Constants.CATEGORY_COLUMN_TITLE
import com.bobby.cloner.utils.Constants.CATEGORY_TABLE_NAME

@Entity(tableName = CATEGORY_TABLE_NAME)
data class CategoryEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = CATEGORY_COLUMN_ID)
    val id: Int = 0,

    @ColumnInfo(name = CATEGORY_COLUMN_ALIAS)
    val aliases: String,

    @ColumnInfo(name = CATEGORY_COLUMN_TITLE)
    val title: String,

    @ColumnInfo(name = CATEGORY_COLUMN_PARENT_ALIAS)
    val parentAlias: String
)
