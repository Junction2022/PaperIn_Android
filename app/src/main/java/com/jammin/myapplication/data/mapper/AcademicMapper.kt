package com.jammin.myapplication.data.mapper

import com.jammin.myapplication.data.model.AcademicEntity
import com.jammin.myapplication.feature.academic.model.ReportModel

fun AcademicEntity.toModel(): List<ReportModel> =
    this.reportList.map {
        ReportModel(
            title = it.title,
            category = it.category
        )
    }
