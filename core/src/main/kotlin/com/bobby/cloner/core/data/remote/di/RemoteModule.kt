package com.bobby.cloner.core.data.remote

import com.bobby.cloner.core.BuildConfig.YELP_BASE_URL
import com.bobby.cloner.utils.Constants.YELP_CLIENT
import com.bobby.cloner.utils.Constants.YELP_RETROFIT
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val remoteModule = module {
    single(named(YELP_CLIENT)) {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .addInterceptor(AuthInterceptor())
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }
    single(named(YELP_RETROFIT)) {
        Retrofit.Builder()
            .baseUrl(YELP_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get(named(YELP_CLIENT)))
            .build()
    }
}
