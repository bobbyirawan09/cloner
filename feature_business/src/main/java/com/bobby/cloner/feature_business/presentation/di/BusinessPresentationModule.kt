package com.bobby.cloner.feature_business.presentation

import com.bobby.cloner.feature_business.presentation.business.BusinessViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Bobby Irawan on 30/07/21.
 */
val businessPresentationModule = module {
    viewModel {
        BusinessViewModel(get())
    }
}
