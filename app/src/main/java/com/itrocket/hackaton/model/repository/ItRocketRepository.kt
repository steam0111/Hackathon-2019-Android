package com.itrocket.hackaton.model.repository

import com.itrocket.hackaton.entity.auth.RegRequest
import com.itrocket.hackaton.model.data.server.ItRocketApi
import com.itrocket.hackaton.model.data.storage.Prefs
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ItRocketRepository (
    private val itRocketApi: ItRocketApi,
    private val prefs: Prefs
) {

      fun getUniversity() =
          itRocketApi
              .getUniversity()
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())


      fun regStudent(regRequest: RegRequest) =
              itRocketApi
                  .studentReg(
                      regRequest.email,
                      regRequest.firstName,
                      regRequest.secondName,
                      regRequest.lastName,
                      regRequest.password,
                      regRequest.universityId)
                  .doAfterSuccess { prefs.accessToken = it.token }
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())

      fun loginStudent(
          email : String,
          password : String
      ) =
          itRocketApi
              .studentLogin(
                  email,
                  password)
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .doOnSuccess {
                  prefs.accessToken = it.token
              }

    fun getProject() =
        itRocketApi
            .getProjects(prefs.accessToken ?: "")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun sendReq(id : String) =
        itRocketApi
            .sendRequest(prefs.accessToken ?: "", id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    fun getTrends() =
        itRocketApi
            .getTrends()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}