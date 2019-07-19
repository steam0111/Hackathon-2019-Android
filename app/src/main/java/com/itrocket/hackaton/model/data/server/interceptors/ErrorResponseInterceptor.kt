package com.itrocket.hackaton.model.data.server.interceptors

import okhttp3.Interceptor
import okhttp3.Response

data class ServerError(val code : Int) : RuntimeException()

class ErrorResponseInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val response = chain.proceed(chain.request())

        val code = response.code()
        if (code in 400..500) throw ServerError(code)

        return response

    }
}