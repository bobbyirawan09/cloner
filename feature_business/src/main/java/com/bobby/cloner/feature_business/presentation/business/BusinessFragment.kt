package com.bobby.cloner.feature_business.presentation.business

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bobby.cloner.feature_business.databinding.FragmentBusinessBinding
import org.koin.android.viewmodel.ext.android.viewModel

class BusinessFragment : Fragment() {

    private var _binding: FragmentBusinessBinding? = null
    private val binding get() = _binding!!

    private val adapter = BusinessAdapter()

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
        binding.rvBusiness.layoutManager = LinearLayoutManager(requireContext())
        binding.rvBusiness.adapter = adapter
        setupObserver()

        viewModel.getBusinesses()
    }

    private fun setupObserver() {
        viewModel.businesses.observe(viewLifecycleOwner) { result ->
            adapter.submitList(result)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = BusinessFragment()
    }

}
