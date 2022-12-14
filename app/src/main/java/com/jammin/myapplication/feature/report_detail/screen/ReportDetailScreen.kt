package com.jammin.myapplication.feature.report_detail.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jammin.myapplication.R
import com.jammin.myapplication.core.component.Header
import com.jammin.myapplication.core.component.PeopleCard
import com.jammin.myapplication.core.component.TableList
import com.jammin.myapplication.core.theme.Body3
import com.jammin.myapplication.feature.report_detail.vm.ReportDetailVM

@Composable
fun ReportDetailScreen(
    reportDetailVM: ReportDetailVM,
    navController: NavController,
    thesisId: String
) {

    val reportDetailContainer = reportDetailVM.container
    val reportDetailState = reportDetailContainer.stateFlow.collectAsState().value
    val reportDetailSideEffect = reportDetailContainer.sideEffectFlow

    LaunchedEffect(Unit) {
        // reportDetailVM.fetchReportList(1)
        reportDetailVM.getThesisDetail(thesisId)
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Header(enabledBackBtn = true, headerText = "Detail") {
            navController.popBackStack()
        }

        Spacer(modifier = Modifier.height(16.dp))

        TableList(tableModel = reportDetailState.tableList)

        Spacer(modifier = Modifier.height(32.dp))

        LazyRow() {
            itemsIndexed(reportDetailState.names) { index, item ->
                PeopleCard(name = item)

                Spacer(modifier = Modifier.width(12.dp))
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        Image(painter = painterResource(id = R.drawable.ic_bottom_design), contentDescription = null, modifier = Modifier.padding(30.dp))
    }
}

@Composable
fun ScoreBoard() {
    Column() {
        Body3(text = "0")
    }
}
