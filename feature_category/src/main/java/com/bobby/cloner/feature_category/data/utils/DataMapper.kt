package com.bobby.cloner.feature_category.data.utils

import com.bobby.cloner.feature_category.data.database.model.CategoryEntity
import com.bobby.cloner.feature_category.data.network.response.CategoryResponse
import com.bobby.cloner.feature_category.domain.model.Category

object DataMapper {

    fun mapResponseToDomain(response: CategoryResponse?) =
        Category(
            response?.alias.orEmpty(),
            response?.parentAliases?.first().orEmpty(),
            response?.title.orEmpty()
        )

    fun mapEntitiesToDomain(entity: List<CategoryEntity>): List<Category> =
        entity.map {
            Category(
                it.title,
                it.parentAlias,
                it.title
            )
        }

    fun mapDomainToEntities(domain: List<Category>): List<CategoryEntity> =
        domain.map {
            CategoryEntity(
                aliases = it.alias,
                parentAlias = it.parentAlias,
                title = it.title
            )
        }

    fun mapResponseToEntities(response: CategoryResponse?): CategoryEntity =
        CategoryEntity(
            aliases = response?.alias.orEmpty(),
            parentAlias = response?.parentAliases?.first().orEmpty(),
            title = response?.title.orEmpty()
        )
}
