package com.bobby.cloner.feature_category.data.utils

import com.bobby.cloner.feature_business.data.network.response.BusinessResponse
import com.bobby.cloner.feature_business.domain.model.Business
import com.bobby.cloner.feature_business.domain.model.BusinessCategory
import com.bobby.cloner.utils.orFalse
import com.bobby.cloner.utils.orZero

object DataMapper {

    fun mapResponseToDomain(response: BusinessResponse?): Business {
        val categories = response?.categories?.map {
            BusinessCategory(
                it.alias.orEmpty(),
                it.title.orEmpty()
            )
        }.orEmpty()
        val displayAddress = response?.location?.displayAddress?.joinToString(", ").orEmpty()
        val displayCategory = categories.joinToString(separator = ", ") {
            it.title
        }
        val displayDistance = String.format("%.2f", response?.distance.orZero())
        return Business(
            response?.rating.orZero(),
            response?.phone.orEmpty(),
            response?.id.orEmpty(),
            response?.isClosed.orFalse(),
            displayCategory,
            response?.reviewCount.orZero().toString(),
            response?.name.orEmpty(),
            response?.imageUrl.orEmpty(),
            displayAddress,
            displayDistance
        )
    }
}
