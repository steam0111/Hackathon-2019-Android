package com.itrocket.hackaton.model.data.server

import com.itrocket.hackaton.entity.TestModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ItRocketApi {
    companion object {
        const val API_PATH = "/api/v1/"
    }

    @POST("${API_PATH}example")
    fun getTest() : Single<List<TestModel>>
}