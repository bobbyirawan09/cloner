package com.bobby.cloner.feature_search.presentation.di

import com.bobby.cloner.feature_search.presentation.SearchViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Bobby Irawan on 26/08/21.
 */
val searchPresentationModule = module {
    viewModel {
        SearchViewModel(get())
    }
}
