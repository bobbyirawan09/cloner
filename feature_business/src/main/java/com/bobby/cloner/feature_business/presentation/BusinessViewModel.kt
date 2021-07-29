package com.bobby.cloner.feature_business.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bobby.cloner.feature_business.domain.model.Business
import com.bobby.cloner.feature_business.domain.usecase.GetBusinessUseCase
import kotlinx.coroutines.flow.Flow

class BusinessViewModel(private val getBusinessUseCase: GetBusinessUseCase) : ViewModel() {
    private var currentQueryValue: String? = null

    private var currentSearchResult: Flow<PagingData<Business>>? = null

    fun searchRepo(queryString: String): Flow<PagingData<Business>> {
        val lastResult = currentSearchResult
        if (queryString == currentQueryValue && lastResult != null) {
            return lastResult
        }
        currentQueryValue = queryString
        val newResult: Flow<PagingData<Business>> =
            getBusinessUseCase.getBusinesses().cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }
}
