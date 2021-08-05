package com.bobby.cloner.feature_business.presentation

import androidx.lifecycle.SavedStateHandle
import com.bobby.cloner.feature_business.presentation.business.BusinessViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Bobby Irawan on 30/07/21.
 */
val businessPresentationModule = module {
    viewModel {
        BusinessViewModel(get(), get())
    }

    single {
        SavedStateHandle()
    }
}
