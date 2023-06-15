package com.dyrelosh.pethotels.utils

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

suspend fun <T : Any> safeApiCall(call: suspend () -> T): ApiResult<T> {
    return withContext(Dispatchers.IO) {
        try {
            ApiResult.Success(call())
        } catch (e: Exception) {
            val error = when (e) {
                is HttpException -> {
                    val code = e.code()
                    ApiResult.Error(e, code)
                }
                is IOException -> ApiResult.NetworkError
                else -> {
                    ApiResult.Error(null)
                }
            }
            e.printStackTrace()
            Log.e("jcm","Error happened in making api call : $error")
            error
        }
    }
}