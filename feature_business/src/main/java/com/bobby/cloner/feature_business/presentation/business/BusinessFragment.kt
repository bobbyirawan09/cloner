package com.bobby.cloner.feature_business.presentation.business

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bobby.cloner.core.presentation.utils.viewBinding
import com.bobby.cloner.feature_business.R
import com.bobby.cloner.feature_business.databinding.FragmentBusinessBinding
import com.bobby.cloner.utils.setGone
import com.bobby.cloner.utils.setVisible
import org.koin.android.viewmodel.ext.android.viewModel

class BusinessFragment : Fragment(R.layout.fragment_business) {

    private val binding: FragmentBusinessBinding by viewBinding(FragmentBusinessBinding::bind)

    private val adapter = BusinessAdapter()

    private val viewModel: BusinessViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupObserver()

        viewModel.getBusinesses()
    }

    override fun onResume() {
        super.onResume()
        binding.shimmerPlaceholderResult.startShimmer()
    }

    override fun onPause() {
        super.onPause()
        binding.shimmerPlaceholderResult.stopShimmer()
    }

    private fun setupView() {
        val decoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        binding.rvBusiness.addItemDecoration(decoration)
        binding.rvBusiness.layoutManager = LinearLayoutManager(requireContext())
        binding.rvBusiness.adapter = adapter

        requireActivity().actionBar?.title = "Testing"
    }

    private fun setupObserver() {
        viewModel.businesses.observe(viewLifecycleOwner) { result ->
            adapter.submitList(result)

            binding.shimmerPlaceholderResult.stopShimmer()
            binding.shimmerPlaceholderResult.setGone()
            binding.rvBusiness.setVisible()
        }

        viewModel.error.observe(viewLifecycleOwner) {
            binding.shimmerPlaceholderResult.stopShimmer()
            binding.shimmerPlaceholderResult.setGone()
        }
    }

    companion object {
        fun newInstance() = BusinessFragment()
    }

}
