package com.bobby.cloner.core.data.remote

import com.bobby.cloner.utils.BuildConfig.YELP_API_KEY
import com.bobby.cloner.utils.Constants.HEADER_AUTHORIZATION
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val originalRequest = chain.request()
        val request = originalRequest.newBuilder()
            .header(HEADER_AUTHORIZATION, "Bearer $YELP_API_KEY")

        return chain.proceed(request.method(originalRequest.method, originalRequest.body).build())
    }
}
