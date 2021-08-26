package com.bobby.cloner

import android.app.Application
import com.bobby.cloner.core.data.remote.remoteModule
import com.bobby.cloner.feature_business.data.di.businessDataModule
import com.bobby.cloner.feature_business.domain.di.businessDomainModule
import com.bobby.cloner.feature_business.presentation.businessPresentationModule
import com.bobby.cloner.feature_search.data.di.searchDataModule
import com.bobby.cloner.feature_search.domain.di.searchDomainModule
import com.bobby.cloner.feature_search.presentation.di.searchPresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ClonerApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@ClonerApplication)
            modules(
                remoteModule,
                businessDataModule,
                businessDomainModule,
                businessPresentationModule,
                searchDataModule,
                searchDomainModule,
                searchPresentationModule
            )
        }
    }
}
