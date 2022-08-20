package com.jammin.myapplication.data.repository

import com.jammin.myapplication.data.model.FetchReportDetailEntity
import javax.inject.Inject

class ReportDetailResponseImpl @Inject constructor() : ReportDetailRepository {
    override suspend fun fetchReportDetail(reportId: Int): Result<FetchReportDetailEntity> =
        kotlin.runCatching {
            val fakeData = FetchReportDetailEntity(
                "https://storage.googleapis.com/static.fastcampus.co.kr/prod/uploads/202107/161246-24/[패스트캠퍼스]-교육과정소개서-초격차-패키지--30개-프로젝트로-배우는-android-앱-개발-with-kotlin.pdf",
                listOf(
                    FetchReportDetailEntity.TableModel("작성자", "임세현"),
                    FetchReportDetailEntity.TableModel("작성자", "임세현"),
                    FetchReportDetailEntity.TableModel("작성자", "임세현"),
                    FetchReportDetailEntity.TableModel("작성자", "임세현")
                )
            )

            fakeData
        }
}
