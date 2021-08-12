package com.bobby.cloner.feature_business.presentation.businessdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bobby.cloner.core.domain.Resource
import com.bobby.cloner.feature_business.domain.model.BusinessDetail
import com.bobby.cloner.feature_business.domain.usecase.GetBusinessDetailsUseCase
import com.bobby.cloner.utils.orZero
import com.google.android.gms.maps.model.LatLng
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class BusinessDetailViewModel(private val useCase: GetBusinessDetailsUseCase) : ViewModel() {

    private var _businessDetail = MutableLiveData<BusinessDetail>()
    val businessDetail = _businessDetail as LiveData<BusinessDetail>

    private var _locationMap = MutableLiveData<Pair<String, LatLng>>()
    val locationMap = _locationMap as LiveData<Pair<String, LatLng>>

    fun getBusinessDetail() {
        viewModelScope.launch {
            useCase.getBusinessDetail("").collect {
                when (it) {
                    is Resource.Error -> {
                    }
                    is Resource.Loading -> {
                    }
                    is Resource.Success -> {
                        val result = it.data
                        val latLng = LatLng(
                            result?.coordinates?.latitude.orZero(),
                            result?.coordinates?.longitude.orZero()
                        )
                        _locationMap.value = Pair(result?.name.orEmpty(), latLng)
                    }
                    is Resource.SuccessButEmpty -> {
//                        _businesses.value = it.data
                    }
                }
            }
        }
    }
}
