package com.bobby.cloner.core.data.remote

import android.accounts.NetworkErrorException
import com.bobby.cloner.core.data.remote.response.ApiResponse
import com.bobby.cloner.core.data.remote.response.YelpErrorResponse
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import okhttp3.ResponseBody
import retrofit2.Response
import java.net.UnknownHostException

/**
 * Created by Bobby Irawan on 25/09/20.
 */
suspend fun <RequestType> networkRequestHandling(
    callApi: suspend () -> Response<RequestType>
) = flow {
    try {
        val requestResult = callApi.invoke()
        with(requestResult) {
            when {
                isSuccessful -> {
                    val response = body() as? RequestType

                    if (response != null) {
                        body()?.let {
                            emit(ApiResponse.Success(it))
                        }
                    } else {
                        emit(ApiResponse.Error("Success request but data not available"))
                    }
                }
                else -> {
                    val errorBody =
                        Gson().fromJson(
                            errorBody()?.stringSuspending(),
                            YelpErrorResponse::class.java
                        )
                    emit(
                        ApiResponse.Error(errorBody.description)
                    )
                }
            }
        }
    } catch (e: Exception) {
        when (e) {
            is NetworkErrorException, is UnknownHostException -> {
                emit(
                    ApiResponse.Error("Tidak ada koneksi internet")
                )
            }
            else -> emit(
                ApiResponse.Error("Maaf, terjadi kesalahan pada server")
            )
        }
    }
}.flowOn(Dispatchers.IO)

@Suppress("BlockingMethodInNonBlockingContext")
suspend fun ResponseBody.stringSuspending() =
    withContext(Dispatchers.IO) { string() }
