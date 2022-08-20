package com.jammin.myapplication.data.repository

import com.jammin.myapplication.data.model.response.FetchReportDetailResponse

interface ReportDetailRepository {
    suspend fun fetchReportDetail(reportId: Int): Result<FetchReportDetailResponse>
}
