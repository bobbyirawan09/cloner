package com.bobby.cloner.feature_business.presentation.business

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bobby.cloner.core.domain.Resource
import com.bobby.cloner.feature_business.domain.model.Business
import com.bobby.cloner.feature_business.domain.usecase.GetBusinessUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BusinessViewModel(private val getBusinessUseCase: GetBusinessUseCase) : ViewModel() {

    private var _businesses = MutableLiveData<List<Business>?>()
    val businesses = _businesses as LiveData<List<Business>?>

    private var _loading = MutableLiveData<Boolean>()
    val loading = _loading as LiveData<Boolean>

    private var _error = MutableLiveData<String>()
    val error = _error as LiveData<String>

    fun getBusinesses() {
        viewModelScope.launch {
            getBusinessUseCase.getBusinesses().collect {
                when (it) {
                    is Resource.Error -> {
                        _error.value = it.message.orEmpty()
                    }
                    is Resource.Loading -> {
                        _loading.value = true
                    }
                    is Resource.Success -> {
                        _businesses.value = it.data
                    }
                    is Resource.SuccessButEmpty -> {
                        _businesses.value = it.data
                    }
                }
            }
        }
    }

//    val businesses = getBusinessUseCase.getBusinesses().cachedIn(viewModelScope)
}
