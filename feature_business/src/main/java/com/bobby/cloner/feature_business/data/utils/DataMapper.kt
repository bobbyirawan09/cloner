package com.bobby.cloner.feature_business.data.utils

import com.bobby.cloner.core.domain.model.Days
import com.bobby.cloner.feature_business.data.network.response.*
import com.bobby.cloner.feature_business.domain.model.*
import com.bobby.cloner.utils.orFalse
import com.bobby.cloner.utils.orZero

object DataMapper {

    fun mapResponseToDomain(response: BusinessResponse?): Business {
        val displayAddress = getDisplayAddress(response?.location?.displayAddress)
        val displayCategory = getDisplayCategory(response?.categories)
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
            displayDistance,
            response?.price.orEmpty()
        )
    }

    fun mapResponseToDomain(response: BusinessDetailResponse?): BusinessDetail {
        val coordinates = getCoordinates(response?.coordinates)
        val displayAddress = getDisplayAddress(response?.location?.displayAddress)
        val openDays = getOpenDay(response?.hours?.firstOrNull()?.open)
        val displayCategory = getDisplayCategory(response?.categories)
        return BusinessDetail(
            rating = response?.rating.orZero(),
            phone = response?.phone.orEmpty(),
            category = displayCategory,
            reviewCount = response?.reviewCount.orZero().toString(),
            name = response?.name.orEmpty(),
            imageUrl = response?.imageUrl.orEmpty(),
            imageBusiness = response?.photos.orEmpty(),
            address = displayAddress,
            coordinates = coordinates,
            openDays = openDays,
            price = response?.price.orEmpty()
        )
    }

    private fun getDisplayCategory(categoryResponse: List<CategoryResponse>?): String {
        val categories = categoryResponse?.map {
            BusinessCategory(
                it.alias.orEmpty(),
                it.title.orEmpty()
            )
        }.orEmpty()
        return categories.joinToString(separator = ", ") {
            it.title
        }
    }

    private fun getDisplayAddress(addressResponse: List<String>?) =
        addressResponse?.joinToString(", ").orEmpty()

    private fun getOpenDay(openResponse: List<OpenResponse>?): List<OpenDay> {
        return openResponse?.map {
            OpenDay(
                it.start.orEmpty(),
                it.end.orEmpty(),
                Days.getDayInString(it.day.orZero())
            )
        }.orEmpty()
    }

    private fun getCoordinates(coordinatesResponse: CoordinatesResponse?) = Coordinates(
        coordinatesResponse?.latitude.orZero(),
        coordinatesResponse?.longitude.orZero()
    )
}
