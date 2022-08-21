package com.jammin.myapplication.feature.report_detail.vm

import androidx.lifecycle.ViewModel
import com.jammin.myapplication.data.mapper.toModel
import com.jammin.myapplication.data.repository.ReportDetailRepository
import com.jammin.myapplication.data.repository.ThesisRepository
import com.jammin.myapplication.feature.report_detail.mvi.ReportDetailSideEffect
import com.jammin.myapplication.feature.report_detail.mvi.ReportDetailState
import com.jammin.myapplication.utils.toTableList
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ReportDetailVM @Inject constructor(
    private val reportDetailRepository: ReportDetailRepository,
    private val thesisRepository: ThesisRepository
) : ContainerHost<ReportDetailState, ReportDetailSideEffect>, ViewModel() {

    override val container =
        container<ReportDetailState, ReportDetailSideEffect>(ReportDetailState())

    fun fetchReportList(reportId: Int) = intent {
        reportDetailRepository.fetchReportDetail(reportId)
            .onSuccess {
                reduce {
                    state.copy(
                        pdfUrl = it.pdfUrl,
                        tableList = it.tableList.map { it.toModel() }
                    )
                }
            }
            .onFailure { }
    }

    fun getThesisDetail(thesisId: String) = intent {
        thesisRepository.getThesis(thesisId)
            .onSuccess {
                reduce {
                    state.copy(
                        pdfUrl = it.thesis.file,
                        tableList = it.thesis.toTableList()
                    )
                }
            }
            .onFailure { }
    }
}
