package com.bobby.cloner.feature_business.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bobby.cloner.feature_business.data.network.service.BusinessService
import com.bobby.cloner.feature_business.domain.model.Business
import com.bobby.cloner.feature_category.data.utils.DataMapper
import com.bobby.cloner.utils.Constants.BUSINESS_RESULT_STARTING_PAGE_INDEX
import com.bobby.cloner.utils.Constants.NETWORK_PAGE_SIZE
import retrofit2.HttpException
import java.io.IOException

/**
 * Created by Bobby Irawan on 29/07/21.
 */

class BusinessPagingSource(private val service: BusinessService) : PagingSource<Int, Business>() {
    override fun getRefreshKey(state: PagingState<Int, Business>): Int? {
        // We need to get the previous key (or next key if previous is null) of the page
        // that was closest to the most recently accessed index.
        // Anchor position is the most recently accessed index
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(anchorPosition)?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Business> {
        val position = params.key ?: BUSINESS_RESULT_STARTING_PAGE_INDEX
        return try {
            val response = service.getBusiness(position, params.loadSize)
            val nextKey = if (response.businesses.isNullOrEmpty()) {
                null
            } else {
                // initial load size = 3 * NETWORK_PAGE_SIZE
                // ensure we're not requesting duplicating items, at the 2nd request
                position + (params.loadSize / NETWORK_PAGE_SIZE)
            }
            val result = response.businesses?.map { businessResponse ->
                DataMapper.mapResponseToDomain(businessResponse)
            }.orEmpty()
            LoadResult.Page(
                data = result,
                prevKey = if (position == BUSINESS_RESULT_STARTING_PAGE_INDEX) null else position - 1,
                nextKey = nextKey
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }
}
