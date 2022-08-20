package com.jammin.myapplication.data.model

data class AcademicEntity(
    val reportList: List<Report>
) {
    data class Report(
        val title: String,
        val category: List<String>
    )
}
