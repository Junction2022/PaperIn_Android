package com.jammin.myapplication.feature.report_detail.screen

import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.jammin.myapplication.core.component.Header
import com.jammin.myapplication.core.component.PDFWebView
import com.jammin.myapplication.core.component.TableList
import com.jammin.myapplication.feature.report_detail.vm.ReportDetailVM

@Composable
fun ReportDetailScreen(
    navController: NavController,
    reportDetailVM: ReportDetailVM
) {
    val reportDetailContainer = reportDetailVM.container
    val reportDetailState = reportDetailContainer.stateFlow.collectAsState().value
    val reportDetailSideEffect = reportDetailContainer.sideEffectFlow

    LaunchedEffect(Unit) {
        reportDetailVM.fetchReportList(1)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)
    ) {
        Header(
            headerText = "Detail",
            enabledBackBtn = true,
            enabledChatBtn = true,
            onPrevious = { navController.popBackStack() }
        ) {

        }

        Spacer(modifier = Modifier.height(16.dp))

        TableList(tableModel = reportDetailState.tableList)

        Spacer(modifier = Modifier.height(21.dp))

        PDFWebView(url = reportDetailState.pdfUrl)

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview
@Composable
fun PreviewEvaluation() {
    ReportDetailScreen(rememberNavController(), hiltViewModel())
}
