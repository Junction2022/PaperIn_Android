package com.jammin.myapplication.data.model.response

data class AcademicResponse(
    val reportList: List<Report>
) {
    data class Report(
        val title: String,
        val category: List<String>
    )
}
