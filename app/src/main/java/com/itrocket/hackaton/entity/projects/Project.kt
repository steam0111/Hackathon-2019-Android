package com.itrocket.hackaton.entity.projects


import com.squareup.moshi.Json
import java.io.Serializable

data class Project(
    @field:Json(name = "id")
    val id : String,
    @field:Json(name = "approved_by_university")
    val approvedByUniversity: List<String>,
    @field:Json(name = "company")
    val company: String = "",
    @field:Json(name = "company_avatar")
    val companyAvatar: String = "",
    @field:Json(name = "count_orders")
    val countOrders: Int = 0,
    @field:Json(name = "list_competitions")
    val listCompetentions: List<String>?,
    @field:Json(name = "project_description")
    val projectDescription: String = "",
    @field:Json(name = "project_foto")
    val projectFoto: String = "",
    @field:Json(name = "project_name")
    val projectName: String = "",
    @field:Json(name = "isOrdered")
    var isOrdered: Int? = 0,
    var payment : Boolean
) : Serializable