package com.itrocket.hackaton.model.repository

import com.itrocket.hackaton.entity.auth.RegRequest
import com.itrocket.hackaton.model.data.server.ItRocketApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ItRocketRepository (private val itRocketApi: ItRocketApi) {

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
                  .subscribeOn(Schedulers.io())
                  .observeOn(AndroidSchedulers.mainThread())
}