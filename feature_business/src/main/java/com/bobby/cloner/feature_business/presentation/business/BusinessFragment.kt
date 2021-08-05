package com.bobby.cloner.feature_business.presentation.business

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.bobby.cloner.feature_business.databinding.FragmentBusinessBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class BusinessFragment : Fragment() {

    private var _binding: FragmentBusinessBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy { BusinessAdapter() }

    @ExperimentalCoroutinesApi
    private val viewModel: BusinessViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBusinessBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val decoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        binding.rvBusiness.addItemDecoration(decoration)

        // bind the state
        binding.bindState(
            uiState = viewModel.state,
            uiActions = viewModel.accept
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    /**
     * Binds the [UiState] provided  by the [SearchRepositoriesViewModel] to the UI,
     * and allows the UI to feed back user actions to it.
     */
    private fun FragmentBusinessBinding.bindState(
        uiState: StateFlow<UiState>,
        uiActions: (UiAction) -> Unit
    ) {
        rvBusiness.adapter = adapter

        bindList(
            businessAdapter = adapter,
            uiState = uiState,
            onScrollChanged = uiActions
        )
    }

    private fun FragmentBusinessBinding.bindList(
        businessAdapter: BusinessAdapter,
        uiState: StateFlow<UiState>,
        onScrollChanged: (UiAction.Scroll) -> Unit
    ) {
        rvBusiness.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy != 0) onScrollChanged(UiAction.Scroll(currentQuery = uiState.value.query))
            }
        })
        val notLoading = businessAdapter.loadStateFlow
            // Only emit when REFRESH LoadState for RemoteMediator changes.
            .distinctUntilChangedBy { it.refresh }
            // Only react to cases where Remote REFRESH completes i.e., NotLoading.
            .map { it.refresh is LoadState.NotLoading }

        val hasNotScrolledForCurrentSearch = uiState
            .map { it.hasNotScrolledForCurrentSearch }
            .distinctUntilChanged()

        val shouldScrollToTop = combine(
            notLoading,
            hasNotScrolledForCurrentSearch
        ) { b, other -> b.and(other) }
            .distinctUntilChanged()

        val pagingData = uiState
            .map { it.pagingData }
            .distinctUntilChanged()

        lifecycleScope.launch {
            combine(shouldScrollToTop, pagingData, ::Pair)
                // Each unique PagingData should be submitted once, take the latest from
                // shouldScrollToTop
                .distinctUntilChangedBy { it.second }
                .collectLatest { (shouldScroll, pagingData) ->
                    businessAdapter.submitData(pagingData)
                    // Scroll only after the data has been submitted to the adapter,
                    // and is a fresh search
                    if (shouldScroll) rvBusiness.scrollToPosition(0)
                }
        }
    }

    companion object {
        fun newInstance() = BusinessFragment()
    }

}
