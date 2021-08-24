package com.bobby.cloner.feature_search.domain.di

import com.bobby.cloner.feature_search.domain.usecase.GetYelpSuggestionUseCase
import org.koin.dsl.module

val searchDomainModule = module {
    single {
        GetYelpSuggestionUseCase(get())
    }
}
