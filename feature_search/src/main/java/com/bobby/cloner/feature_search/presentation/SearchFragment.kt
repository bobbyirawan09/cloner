package com.bobby.cloner.feature_search.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bobby.cloner.core.presentation.listener.EditTextListener
import com.bobby.cloner.core.presentation.utils.viewBinding
import com.bobby.cloner.feature_search.databinding.FragmentSearchBinding
import com.bobby.cloner.feature_search.presentation.adapter.SearchAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class SearchFragment : Fragment() {

    private val binding: FragmentSearchBinding by viewBinding(FragmentSearchBinding::bind)
    private val viewModel by viewModel<SearchViewModel>()
    private val adapter by lazy { SearchAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initObserver()
    }

    private fun initObserver() {
        viewModel.suggestion.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun initView() {
        val decoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        binding.rvSearch.addItemDecoration(decoration)
        binding.rvSearch.layoutManager = LinearLayoutManager(requireContext())
        binding.rvSearch.adapter = adapter

        val editTextListener = EditTextListener {query ->
            viewModel.searchQuery(query)
        }
        binding.tieSearch.addTextChangedListener(editTextListener)
    }

}
