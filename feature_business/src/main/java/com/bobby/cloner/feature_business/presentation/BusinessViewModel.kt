package com.bobby.cloner.feature_business.presentation

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bobby.cloner.feature_business.domain.model.Business
import com.bobby.cloner.feature_business.domain.usecase.GetBusinessUseCase
import com.bobby.cloner.utils.Constants.LAST_QUERY_SCROLLED
import com.bobby.cloner.utils.Constants.LAST_SEARCH_QUERY
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class BusinessViewModel(private val getBusinessUseCase: GetBusinessUseCase, private val savedStateHandle: SavedStateHandle) : ViewModel() {

    val state: StateFlow<UiState>

    val accept: (UiAction) -> Unit

    init {
        val initialQuery: String = savedStateHandle.get(LAST_SEARCH_QUERY) ?: "Johor Bahru"
        val lastQueryScrolled: String? = savedStateHandle.get(LAST_QUERY_SCROLLED)
        val actionStateFlow = MutableSharedFlow<UiAction>()
        val searches = actionStateFlow
            .filterIsInstance<UiAction.Search>()
            .distinctUntilChanged()
        val queriesScrolled = actionStateFlow
            .filterIsInstance<UiAction.Scroll>()
            .distinctUntilChanged()
            // This is shared to keep the flow "hot" while caching the last query scrolled,
            // otherwise each flatMapLatest invocation would lose the last query scrolled,
            .shareIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
                replay = 1
            )
            .onStart { emit(UiAction.Scroll(currentQuery = lastQueryScrolled)) }

        state = searches
            .flatMapLatest { search ->
                combine(
                    queriesScrolled,
                    searchBusiness(),
                    ::Pair
                )
                    // Each unique PagingData should be submitted once, take the latest from
                    // queriesScrolled
                    .distinctUntilChangedBy { it.second }
                    .map { (scroll, pagingData) ->
                        UiState(
                            query = "Johor Bahru",
                            pagingData = pagingData,
                            lastQueryScrolled = scroll.currentQuery,
                            // If the search query matches the scroll query, the user has scrolled
                            hasNotScrolledForCurrentSearch = "Johor Bahru" != scroll.currentQuery
                        )
                    }
            }
            .onStart { emit(UiState()) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
                initialValue = UiState()
            )

        accept = { action ->
            viewModelScope.launch { actionStateFlow.emit(action) }
        }
    }

    private suspend fun searchBusiness(): Flow<PagingData<Business>> = getBusinessUseCase.getBusinesses().cachedIn(viewModelScope)

    override fun onCleared() {
        savedStateHandle[LAST_SEARCH_QUERY] = state.value.query
        savedStateHandle[LAST_QUERY_SCROLLED] = state.value.lastQueryScrolled
        super.onCleared()
    }
}

sealed class UiAction {
    object Search : UiAction()
    data class Scroll(val currentQuery: String?) : UiAction()
}

data class UiState(
    val query: String = "",
    val lastQueryScrolled: String? = null,
    val hasNotScrolledForCurrentSearch: Boolean = false,
    val pagingData: PagingData<Business> = PagingData.empty()
)
