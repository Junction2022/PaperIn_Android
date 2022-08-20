package com.jammin.myapplication.data.mapper

import com.jammin.myapplication.data.model.response.AcademicResponse
import com.jammin.myapplication.feature.academic.model.ReportModel

fun AcademicResponse.toModel(): List<ReportModel> =
    this.reportList.map {
        ReportModel(
            title = it.title,
            category = it.category
        )
    }
