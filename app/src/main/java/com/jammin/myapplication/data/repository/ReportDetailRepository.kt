package com.jammin.myapplication.data.repository

import com.jammin.myapplication.data.model.FetchReportDetailEntity

interface ReportDetailRepository {
    suspend fun fetchReportDetail(reportId: Int): Result<FetchReportDetailEntity>
}