package com.bobby.cloner.feature_business.presentation.businessdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bobby.cloner.feature_business.R

class BusinessDetailFragment : Fragment() {

    companion object {
        fun newInstance() = BusinessDetailFragment()
    }

    private lateinit var viewModel: BusinessDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_business_detail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BusinessDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
