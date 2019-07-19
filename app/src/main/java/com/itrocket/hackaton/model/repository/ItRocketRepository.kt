package com.itrocket.hackaton.model.repository

import com.itrocket.hackaton.model.data.server.ItRocketApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ItRocketRepository (private val itRocketApi: ItRocketApi) {
      fun getTestModel() =
          itRocketApi
              .getTest()
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())

}