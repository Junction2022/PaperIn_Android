package com.jammin.myapplication.feature.report_detail.mvi

import com.jammin.myapplication.core.component.TableModel

data class ReportDetailState(
    val isLoading: Boolean = false,
    val pdfUrl: String = String(),
    val tableList: List<TableModel> = listOf(),
    val names: List<String> = listOf("임세현", "최성현", "박경헌", "이준서", "공승환", "미더덕", "최수완")
)
