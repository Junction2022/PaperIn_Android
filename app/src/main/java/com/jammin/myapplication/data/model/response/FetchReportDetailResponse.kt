package com.jammin.myapplication.data.model.response

data class FetchReportDetailResponse(
    val pdfUrl: String,
    val tableList: List<TableModel>
) {
    data class TableModel(
        val title: String,
        val description: String
    )
}
