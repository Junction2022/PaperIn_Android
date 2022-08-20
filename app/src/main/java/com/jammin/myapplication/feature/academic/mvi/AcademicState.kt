package com.jammin.myapplication.feature.academic.mvi

import com.jammin.myapplication.feature.academic.model.ReportModel

data class AcademicState(
    val isLoading: Boolean = false,
    val searchValue: String = "",
    val reportList: List<ReportModel> = listOf()
)
