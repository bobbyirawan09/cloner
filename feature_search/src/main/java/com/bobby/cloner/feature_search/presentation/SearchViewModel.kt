package com.bobby.cloner.feature_search.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bobby.cloner.core.domain.Resource
import com.bobby.cloner.feature_search.domain.model.AutocompleteSuggestion
import com.bobby.cloner.feature_search.domain.usecase.GetYelpSuggestionUseCase
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch

class SearchViewModel(private val useCase: GetYelpSuggestionUseCase) : ViewModel() {

    private var _suggestion = MutableLiveData<List<AutocompleteSuggestion>?>()
    val suggestion = _suggestion as LiveData<List<AutocompleteSuggestion>?>

    private var _error = MutableLiveData<String>()
    val error = _error as LiveData<String>

    @FlowPreview
    fun searchQuery(query: String) {
        viewModelScope.launch {
            useCase.getAutocompleteSuggestion(query)
                .debounce(300)
                .collect {
                    when(it) {
                        is Resource.Error -> {
                            _error.value = it.message.orEmpty()
                        }
                        is Resource.Success -> {
                            _suggestion.value = it.data
                        }
                        is Resource.SuccessButEmpty -> {
                            _suggestion.value = it.data
                        }
                    }
                }
        }
    }
}
