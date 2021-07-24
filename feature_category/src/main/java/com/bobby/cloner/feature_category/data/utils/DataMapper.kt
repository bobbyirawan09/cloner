package com.bobby.cloner.feature_category.data.utils

import com.bobby.cloner.feature_category.data.network.response.CategoryResponse
import com.bobby.cloner.feature_category.domain.model.Category

object DataMapper {

    fun mapResponseToEntities(response: CategoryResponse?) =
        Category(
            response?.alias.orEmpty(),
            response?.parentAliases.orEmpty(),
            response?.title.orEmpty()
        )
}
