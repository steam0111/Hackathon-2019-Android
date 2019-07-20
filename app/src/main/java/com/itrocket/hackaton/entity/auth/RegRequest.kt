package com.itrocket.hackaton.entity.auth

import com.squareup.moshi.Json

class RegRequest(
    @field:Json(name = "email")
    var email : String,
    @field:Json(name = "first_name")
    var firstName : String,
    @field:Json(name = "second_name")
    var secondName : String,
    @field:Json(name = "last_name")
    var lastName : String,
    @field:Json(name = "password")
    var password : String,
    @field:Json(name = "id_university")
    var universityId : Int)