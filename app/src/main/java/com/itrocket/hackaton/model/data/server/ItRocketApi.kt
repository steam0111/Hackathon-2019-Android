package com.itrocket.hackaton.model.data.server

import com.itrocket.hackaton.entity.TestModel
import com.itrocket.hackaton.entity.Trend
import com.itrocket.hackaton.entity.auth.Token
import com.itrocket.hackaton.entity.projects.Msg
import com.itrocket.hackaton.entity.projects.Project
import com.itrocket.hackaton.entity.university.University
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface ItRocketApi {
    companion object {
        const val API_PATH = "/api/v1/"
    }

    @POST("${API_PATH}example")
    fun getTest() : Single<List<TestModel>>

    @POST("${API_PATH}student/registration")
    @FormUrlEncoded
    fun studentReg(
        @Field("email") email : String,
        @Field("first_name") firstName : String,
        @Field("second_name") secondName : String,
        @Field("last_name") lastName : String,
        @Field("password") password : String,
        @Field("id_university") universityId : Int
    ) : Single<Token>

    @POST("${API_PATH}student/login")
    @FormUrlEncoded
    fun studentLogin(
        @Field("email") email : String,
        @Field("password") password : String
    ) : Single<Token>

    @POST("${API_PATH}get-universities")
    fun getUniversity() : Single<List<University>>

    @POST("${API_PATH}get-projects")
    fun getProjects(@Header("x-access-token") token : String) : Single<List<Project>>

    @POST("${API_PATH}student/membership-request")
    @FormUrlEncoded
    fun sendRequest(@Header("x-access-token") token : String,
                    @Field("id") id : String) : Single<Msg>


    @POST("${API_PATH}get-popular-competencies")
    fun getTrends() : Single<List<Trend>>
}