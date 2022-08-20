package com.jammin.myapplication.data.repository

import com.jammin.myapplication.data.model.AcademicEntity
import com.jammin.myapplication.data.network.ServerAPI
import javax.inject.Inject

class AcademicRepositoryImpl @Inject constructor(
) : AcademicRepository {

    override suspend fun fetchAcademic(): Result<AcademicEntity> = kotlin.runCatching {
        val fakeData =
            AcademicEntity(
                listOf(
                    AcademicEntity.Report(
                        "대덕소프트웨어마이스터고등학교식 정치에 관한 분석과 파급 효과에 대한 분석",
                        listOf("저자 최성현, 임세현", "고구려대학교 정치학과", "잠자고싶어요 잠자고 싶어요 ㅠㅠ", "찡찡연구회")
                    ),
                    AcademicEntity.Report(
                        "대덕소프트웨어마이스터고등학교식 정치에 관한 분석과 파급 효과에 대한 분석",
                        listOf("저자 최성현, 임세현", "고구려대학교 정치학과", "잠자고싶어요 잠자고 싶어요 ㅠㅠ", "찡찡연구회")
                    ),
                    AcademicEntity.Report(
                        "대덕소프트웨어마이스터고등학교식 정치에 관한 분석과 파급 효과에 대한 분석",
                        listOf("저자 최성현, 임세현", "고구려대학교 정치학과", "잠자고싶어요 잠자고 싶어요 ㅠㅠ", "찡찡연구회")
                    ),
                    AcademicEntity.Report(
                        "대덕소프트웨어마이스터고등학교식 정치에 관한 분석과 파급 효과에 대한 분석",
                        listOf("저자 최성현, 임세현", "고구려대학교 정치학과", "잠자고싶어요 잠자고 싶어요 ㅠㅠ", "찡찡연구회")
                    ),
                    AcademicEntity.Report(
                        "대덕소프트웨어마이스터고등학교식 정치에 관한 분석과 파급 효과에 대한 분석",
                        listOf("저자 최성현, 임세현", "고구려대학교 정치학과", "잠자고싶어요 잠자고 싶어요 ㅠㅠ", "찡찡연구회")
                    )
                )
            )

        fakeData
    }
}
