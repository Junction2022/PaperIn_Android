package com.jammin.myapplication.feature.profile.mvi

import com.jammin.myapplication.core.component.CommentModel
import com.jammin.myapplication.feature.academic.model.ReportModel
import com.jammin.myapplication.utils.TierEnum

data class MyPageState(
    val tier: TierEnum = TierEnum.IRON,
    val profileImageUrl: String ? = null,
    val nickname: String ? = null,
    val academicPageNum: Int = 0,
    val reportModel: List<ReportModel> = listOf(),
    val commentNum: Int = 0,
    val commentModel: List<CommentModel> = listOf()
)
