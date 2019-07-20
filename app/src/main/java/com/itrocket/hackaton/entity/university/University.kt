package com.itrocket.hackaton.entity.university


import com.squareup.moshi.Json

data class University(
    @field:Json(name = "id")
    val id: Int,
    @field:Json(name = "name")
    val name: String
)