package com.jammin.myapplication.data.model

data class FetchReportDetailEntity(
    val pdfUrl: String,
    val tableList: List<TableModel>
) {
    data class TableModel(
        val title: String,
        val description: String
    )
}
